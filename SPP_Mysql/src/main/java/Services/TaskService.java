package Services;

import Models.TaskModel;
import Models.ProjectModel;
import Models.UserModel;
import ORM.TaskORM;
import ORM.ProjectORM;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import Services.SendEmailService;
import javax.swing.JOptionPane;

public class TaskService {

    TaskORM taskORM = new TaskORM();
    ProjectORM projectORM = new ProjectORM();

    public String createTask(TaskModel task) {
        try {

            if (task.getProject() == null) {
                return "Proyecto no encontrado";
            }

            taskORM.create(task);
            return "Tarea creada exitosamente";
        } catch (Exception e) {
            return "Error al crear tarea: " + e.getMessage();
        }
    }

    public String updateTask(TaskModel task) {
        try {
            taskORM.edit(task);
            return "Tarea actualizada exitosamente";
        } catch (Exception e) {
            return "Error al actualizar tarea: " + e.getMessage();
        }
    }

    public String deleteTask(Long id) {
        try {
            taskORM.destroy(id);
            return "Tarea eliminada exitosamente";
        } catch (Exception e) {
            return "Error al eliminar tarea: " + e.getMessage();
        }
    }

    public TaskModel getTask(Long id) {
        return taskORM.find(id);
    }

    public List<TaskModel> getTasksByProject(Long projectId) {
        return taskORM.findByProject(projectId);
    }

    public List<TaskModel> getTasksByProjectAndStatus(Long projectId, TaskModel.Status status) {
        return taskORM.findByProjectAndStatus(projectId, status);
    }

    public List<TaskModel> getAllTasks() {
        return taskORM.findAll();
    }

    public String CalculateTaskPercent() {
        List<TaskModel> allTask = this.getAllTasks();
        float total = 0;
        float complete = 0;

        if (allTask != null) {
            for (TaskModel t : allTask) {
                if (t == null) {
                    continue;
                }
                total++;
                if (t.isCompleted()) {
                    complete++;
                }
            }
        }
        float result = (total > 0) ? (complete / total) * 100 : 0;
        System.out.println("total " + result + " complete " + complete + " total " + total);
        int percentInt = (int) result;
        return String.valueOf(percentInt);
    }

    public int calculateProgress(List<TaskModel> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return 0;
        }

        long completedTasks = 0;
        for (TaskModel task : tasks) {
            if (task.isCompleted()) {
                completedTasks++;
            }
        }

        return (int) ((completedTasks * 100) / tasks.size());
    }

    public String calculateTimeRemaining(List<TaskModel> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return "N/A";
        }

        int totalDaysRemaining = 0;
        for (TaskModel task : tasks) {
            if (!task.isCompleted()) {
                totalDaysRemaining += task.getDurationDays() != null ? task.getDurationDays() : 0;
            }
        }

        if (totalDaysRemaining == 0) {
            return "Completado";
        } else if (totalDaysRemaining == 1) {
            return "1d";
        } else if (totalDaysRemaining < 7) {
            return totalDaysRemaining + "d";
        } else if (totalDaysRemaining < 30) {
            return (totalDaysRemaining / 7) + "w";
        } else {
            return (totalDaysRemaining / 30) + "m";
        }
    }

    public List<Object[]> calculateWorkloadTableData(Long projectId, List<UserModel> users) {
        List<Object[]> tableRows = new ArrayList<>();
        List<TaskModel> allTasks = getTasksByProject(projectId);

        for (UserModel user : users) {
            int totalDays = 0;
            int totalTasks = 0;

            for (TaskModel task : allTasks) {
                if (task.getAssignedUser() != null && task.getAssignedUser().getId().equals(user.getId())) {
                    totalTasks++;
                    if (!task.isCompleted()) {
                        totalDays += task.getDurationDays() != null ? task.getDurationDays() : 0;
                    }
                }
            }

            if (totalTasks > 0) {
                String userName = user.getName();
                int capacidad = 40;
                int asignadas = totalDays * 8;
                int variacion = asignadas - capacidad;
                String estado = variacion > 0 ? "Sobreasignado" : "OK";

                tableRows.add(new Object[]{
                    userName,
                    capacidad,
                    asignadas,
                    (variacion > 0 ? "+" : "") + variacion,
                    estado
                });

                if (variacion > 0) {
                    final String emailTo = user.getEmail();
                    final String name = userName;
                    final int cap = capacidad;
                    final int asig = asignadas;
                    final int var = variacion;

                    if (emailTo != null && emailTo.contains("@") && emailTo.contains(".")) {
                        new Thread(() -> {
                            try {
                                String htmlBody =
                                    "<!DOCTYPE html>" +
                                    "<html>" +
                                    "<head><meta charset='UTF-8'></head>" +
                                    "<body style='font-family: Arial, sans-serif; background-color: #f5f5f5; margin: 0; padding: 20px;'>" +
                                    "  <div style='max-width: 600px; margin: 0 auto; background-color: white; border-radius: 10px; overflow: hidden; box-shadow: 0 2px 10px rgba(0,0,0,0.1);'>" +
                                    "    <div style='background-color: #dc3545; padding: 30px; text-align: center;'>" +
                                    "      <h1 style='color: #ffffff; margin: 0; font-size: 24px; text-shadow: 1px 1px 2px rgba(0,0,0,0.3);'>⚠️ Alerta de Carga Laboral</h1>" +
                                    "    </div>" +
                                    "    <div style='padding: 30px;'>" +
                                    "      <p style='font-size: 16px; color: #333; margin-bottom: 20px;'>Hola <strong>" + name + "</strong>,</p>" +
                                    "      <p style='font-size: 14px; color: #666; line-height: 1.6;'>Tu carga de trabajo actual <strong style='color: #dc3545;'>excede tu capacidad semanal</strong>. Te recomendamos revisar tu asignación de tareas.</p>" +
                                    "      <div style='background-color: #fff3cd; border-left: 4px solid #ffc107; padding: 15px; margin: 20px 0; border-radius: 4px;'>" +
                                    "        <table style='width: 100%; border-collapse: collapse;'>" +
                                    "          <tr>" +
                                    "            <td style='padding: 8px 0; color: #856404; font-size: 14px;'><strong>Capacidad semanal:</strong></td>" +
                                    "            <td style='padding: 8px 0; color: #856404; font-size: 14px; text-align: right;'>" + cap + " horas</td>" +
                                    "          </tr>" +
                                    "          <tr>" +
                                    "            <td style='padding: 8px 0; color: #856404; font-size: 14px;'><strong>Horas asignadas:</strong></td>" +
                                    "            <td style='padding: 8px 0; color: #dc3545; font-size: 14px; text-align: right; font-weight: bold;'>" + asig + " horas</td>" +
                                    "          </tr>" +
                                    "          <tr style='border-top: 2px solid #ffc107;'>" +
                                    "            <td style='padding: 8px 0; color: #856404; font-size: 14px;'><strong>Excedente:</strong></td>" +
                                    "            <td style='padding: 8px 0; color: #dc3545; font-size: 16px; text-align: right; font-weight: bold;'>+" + var + " horas</td>" +
                                    "          </tr>" +
                                    "        </table>" +
                                    "      </div>" +
                                    "      <div style='background-color: #d1ecf1; border-left: 4px solid #0c5460; padding: 15px; margin: 20px 0; border-radius: 4px;'>" +
                                    "        <p style='margin: 0; color: #0c5460; font-size: 14px;'><strong>💡 Recomendación:</strong> Contacta a tu gestor de proyectos para redistribuir las tareas o ajustar los plazos.</p>" +
                                    "      </div>" +
                                    "    </div>" +
                                    "    <div style='background-color: #f8f9fa; padding: 20px; text-align: center; border-top: 1px solid #dee2e6;'>" +
                                    "      <p style='margin: 0; color: #6c757d; font-size: 12px;'>Sistema de Planificación de Proyectos</p>" +
                                    "      <p style='margin: 5px 0 0 0; color: #6c757d; font-size: 12px;'>Este es un mensaje automático, por favor no responder.</p>" +
                                    "    </div>" +
                                    "  </div>" +
                                    "</body>" +
                                    "</html>";

                                SendEmailService.sendPlain(
                                        "smtp.gmail.com", 587,
                                        "esteban.buitrago.o@gmail.com",
                                        "zqibxfszyhgufbkq",
                                        emailTo,
                                        "⚠️ Alerta: Sobrecarga de Trabajo",
                                        htmlBody
                                );
                                System.out.println("✓ Correo enviado a: " + emailTo);
                            } catch (Exception ex) {
                                System.err.println("✗ Error enviando correo a " + emailTo + ": " + ex.getMessage());
                            }
                        }).start();
                    } else {
                        System.err.println("⚠ Usuario '" + name + "' sin email válido. No se envió correo.");
                    }
                }
            }
        }

        return tableRows;
    }
}
