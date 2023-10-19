-- Registros para la entidad "cuenta"
-- CODIGO | CONTRASEÑA | CORREO
insert into cuenta values(1, 'contraseña1', 'pepito@email.com');
insert into cuenta values(2, 'contraseña2', 'juanita@email.com');
insert into cuenta values(3, 'contraseña3', 'carlos@email.com');
insert into cuenta values(4, 'contraseña4', 'laura@email.com');
insert into cuenta values(5, 'contraseña5', 'roberto@email.com');
insert into cuenta values(6, 'contraseña6', 'ana@email.com');
insert into cuenta values(7, 'contraseña7', 'maria@email.com');
insert into cuenta values(8, 'contraseña8', 'pedro@email.com');
insert into cuenta values(9, 'contraseña9', 'sara@email.com');
insert into cuenta values(10, 'contraseña10', 'david@email.com');

-- Registros para la entidad "administrador"
-- CODIGO
insert into administrador values(1);
insert into administrador values(2);
insert into administrador values(3);
insert into administrador values(4);
insert into administrador values(5);

-- Registros para la entidad "paciente"
-- CODIGO | ESTADO (0: ACTIVO, 1: INACTIVO) | FECHA_NACIMIENTO | CEDULA | TELEFONO | NOMBRE | ALERGIAS | URL_FOTO | CIUDAD | EPS | TIPO_SANGRE
insert into paciente values(1, 0, '1990-05-15', '1001', '555-111', 'Juan Perez', 'Alergia al polvo', 'https://url_foto1.com', 'ARMENIA', 'COMFENALCO', 'A_POSITIVO');
insert into paciente values(2, 0, '1985-09-20', '1002', '555-222', 'Laura Garcia', 'Alergia al polen', 'https://url_foto2.com', 'BOGOTA', 'COMPENSAR', 'B_NEGATIVO');
insert into paciente values(3, 0, '1992-03-10', '1003', '555-333', 'Carlos Rodriguez', 'Alergia al maní', 'https://url_foto3.com', 'CALARCA', 'COOMEVA', 'O_POSITIVO');
insert into paciente values(4, 0, '1988-07-25', '1004', '555-444', 'Ana Martinez', 'Alergia a los mariscos', 'https://url_foto4.com', 'CALI', 'FAMISANAR', 'A_NEGATIVO');
insert into paciente values(5, 0, '1980-11-05', '1005', '555-555', 'Sara Lopez', 'Alergia al látex', 'https://url_foto5.com', 'CIRCASIA', 'MEDIMAS', 'AB_POSITIVO');
insert into paciente values(6, 0, '1975-02-18', '1006', '555-666', 'Pedro Torres', 'Alergia a las picaduras de avispas', 'https://url_foto6.com', 'DOSQUEBRADAS', 'NUEVA_EPS', 'B_POSITIVO');
insert into paciente values(7, 0, '1995-12-30', '1007', '555-777', 'Maria Gonzalez', 'Alergia a los ácaros', 'https://url_foto7.com', 'IBAGUE', 'SALUD_TOTAL', 'AB_NEGATIVO');
insert into paciente values(8, 0, '1987-06-14', '1008', '555-888', 'Roberto Sanchez', 'Alergia al moho, alergia al polen', 'https://url_foto8.com', 'MANIZALES', 'SANITAS', 'O_NEGATIVO');
insert into paciente values(9, 0, '1991-04-03', '1009', '555-999', 'Luis Fernandez', 'Alergia al gluten', 'https://url_foto9.com', 'PEREIRA', 'SURA', 'A_POSITIVO');
insert into paciente values(10, 0, '1983-08-08', '1010', '555-000', 'Julia Ramírez', 'Alergia a los gatos', 'https://url_foto10.com', 'SALENTO', 'SURA', 'B_NEGATIVO');

-- Registros para la entidad "medico"
-- CODIGO | ESTADO (0: ACTIVO, 1: INACTIVO) | CEDULA | TELEFONO | NOMBRE | URL_FOTO | CIUDAD | ESPECIALIDAD
insert into medico values(1, 0, '1989678967', '555-123', 'Dr. Rodriguez', 'https://url_foto1.com', 'ARMENIA', 'CARDIOLOGIA');
insert into medico values(2, 0, '3214567890', '555-234', 'Dra. Perez', 'https://url_foto2.com', 'BOGOTA', 'DERMATOLOGIA');
insert into medico values(3, 0, '7890123456', '555-345', 'Dr. Gómez', 'https://url_foto3.com', 'CALARCA', 'ENDOCRINOLOGIA');
insert into medico values(4, 0, '4567890123', '555-456', 'Dra. Lopez', 'https://url_foto4.com', 'CALI', 'GASTROENTEROLOGIA');
insert into medico values(5, 0, '2345678901', '555-567', 'Dr. Martinez', 'https://url_foto5.com', 'CIRCASIA', 'GINECOLOGIA');
insert into medico values(6, 0, '8901234567', '555-678', 'Dra. Fernandez', 'https://url_foto6.com', 'DOSQUEBRADAS', 'MEDICINA_GENERAL');
insert into medico values(7, 0, '5678901234', '555-789', 'Dr. Ramirez', 'https://url_foto7.com', 'IBAGUE', 'NEUROLOGIA');
insert into medico values(8, 0, '3456789012', '555-890', 'Dra. Sanchez', 'https://url_foto8.com', 'MANIZALES', 'OFTALMOLOGIA');
insert into medico values(9, 0, '1234567890', '555-901', 'Dr. Torres', 'https://url_foto9.com', 'PEREIRA', 'OTORRINOLARINGOLOGIA');
insert into medico values(10, 0, '6789012345', '555-012', 'Dra. Gonzalez', 'https://url_foto10.com', 'SALENTO', 'PEDIATRIA');

-- Registros para la entidad "cita"
-- CODIGO | MEDICO_CODIGO | PACIENTE_CODIGO | FECHA_CITA | FECHA_CREACION | MOTIVO | ESTADO (CANCELADA, COMPLETADA, PROGRAMADA)
insert into cita values(1, 3, 8, '2023-10-06 09:30:00', '2023-10-05 08:00:00', 'Consulta médica', 'COMPLETADA');
insert into cita values(2, 6, 1, '2023-10-06 11:15:00', '2023-10-05 09:20:00', 'Examen de rutina', 'COMPLETADA');
insert into cita values(3, 9, 4, '2023-10-06 13:00:00', '2023-10-05 10:45:00', 'Control de medicación', 'CANCELADA');
insert into cita values(4, 3, 7, '2023-10-06 15:45:00', '2023-10-05 12:30:00', 'Seguimiento postoperatorio', 'CANCELADA');
insert into cita values(5, 5, 10, '2023-10-06 17:30:00', '2023-10-05 14:15:00', 'Evaluación dental', 'CANCELADA');
insert into cita values(6, 8, 2, '2023-10-06 09:00:00', '2023-10-05 15:05:00', 'Terapia física', 'CANCELADA');
insert into cita values(7, 10, 5, '2023-10-06 11:30:00', '2023-10-05 16:40:00', 'Consulta psicológica', 'COMPLETADA');
insert into cita values(8, 4, 9, '2023-10-06 14:15:00', '2023-10-05 17:55:00', 'Control de embarazo', 'CANCELADA');
insert into cita values(9, 3, 3, '2023-10-06 16:00:00', '2023-10-05 19:20:00', 'Chequeo de laboratorio', 'COMPLETADA');
insert into cita values(10, 7, 6, '2023-10-06 18:45:00', '2023-10-05 20:10:00', 'Consulta de alergias', 'CANCELADA');

-- Registros para la entidad "pqrs"
-- CITA_CODIGO | CODIGO | FECHA_CREACION | MOTIVO | ESTADO (ARCHIVADO, EN_PROCESO, NUEVO, RESUELTO)
insert into pqrs values(1, 1, '2023-10-05 08:30:00', 'Consulta sobre factura', 'ARCHIVADO');
insert into pqrs values(2, 2, '2023-10-05 10:45:00', 'Reclamo por servicio', 'ARCHIVADO');
insert into pqrs values(1, 3, '2023-10-05 13:15:00', 'Solicitud de información', 'EN_PROCESO');
insert into pqrs values(7, 4, '2023-10-05 15:40:00', 'Queja sobre producto', 'NUEVO');
insert into pqrs values(9, 5, '2023-10-05 17:55:00', 'Reporte de fallo', 'RESUELTO');
insert into pqrs values(2, 6, '2023-10-05 19:20:00', 'Reclamo por demora', 'RESUELTO');
insert into pqrs values(7, 7, '2023-10-05 08:50:00', 'Solicitud de reembolso', 'EN_PROCESO');
insert into pqrs values(1, 8, '2023-10-05 11:10:00', 'Consulta técnica', 'NUEVO');
insert into pqrs values(9, 9, '2023-10-05 14:30:00', 'Queja sobre atención', 'RESUELTO');
insert into pqrs values(7, 10, '2023-10-05 16:45:00', 'Reclamo por error', 'RESUELTO');

-- Registros para la entidad "mensaje"
-- CODIGO | CUENTA_CODIGO | MSJPADRE_CODIGO | PQRS_CODIGO | FECHA_CREACION | MENSAJE
insert into mensaje values(1, 2, null, 2, '2023-10-05 09:00:00', 'Hola, buenos días');
insert into mensaje values(2, 5, null, 4, '2023-10-05 10:30:00', 'Necesito información sobre el horario de atención');
insert into mensaje values(3, 7, null, 1, '2023-10-05 14:15:00', 'Buenas tardes');
insert into mensaje values(4, 1, null, 2, '2023-10-05 16:45:00', '¡Necesito ayuda!');
insert into mensaje values(5, 3, null, 3, '2023-10-05 18:20:00', 'Necesito información sobre un medicamento');
insert into mensaje values(6, 9, null, 5, '2023-10-05 20:10:00', 'Buenas noches');
insert into mensaje values(7, 6, null, 8, '2023-10-05 09:45:00', '¿Cómo puedo hacer una reclamación?');
insert into mensaje values(8, 6, 7, 8, '2023-10-05 11:30:00', 'Por este medio puede hacer una reclamación');
insert into mensaje values(9, 6, 8, 8, '2023-10-05 15:00:00', 'Muchas gracias');
insert into mensaje values(10, 6, 9, 8, '2023-10-05 17:30:00', 'Con mucho gusto');

-- Registros para la entidad "atencion_medica"
-- CITA_CODIGO | CODIGO | DIAGNOSTICO | TRATAMIENTO | NOTAS
insert into atencion_medica values(3, 1, 'Fiebre y dolor de cabeza', 'Paracetamol 500mg cada 6 horas', 'Se recomienda reposo y tomar paracetamol');
insert into atencion_medica values(5, 2, 'Dolor abdominal', 'Referir al especialista', 'Se necesita hacer pruebas adicionales');
insert into atencion_medica values(7, 3, 'Presión arterial alta', 'Recetar medicamento antihipertensivo', 'Controlar la dieta y hacer ejercicio');
insert into atencion_medica values(1, 4, 'Fractura de brazo', 'Inmovilizar el brazo y derivar a un ortopedista', 'Se necesita una radiografía');
insert into atencion_medica values(8, 5, 'Dolor de muelas', 'Revisión y limpieza dental', 'Posible caries dental');
insert into atencion_medica values(4, 6, 'Dolor de espalda', 'Recetar analgésicos y derivar a fisioterapia', 'Sugerir cambios en la postura y ejercicios');
insert into atencion_medica values(6, 7, 'Problemas de ansiedad', 'Terapia cognitivo-conductual', 'Necesita consulta con psicólogo');
insert into atencion_medica values(10, 8, 'Gripe y fiebre', 'Antigripales y paracetamol', 'Reposo y mantenerse hidratado');
insert into atencion_medica values(2, 9, 'Infección en la piel', 'Aplicar crema antibiótica', 'Tomar antibióticos');
insert into atencion_medica values(9, 10, 'Problemas digestivos', 'Recomendar dieta y ejercicio regular', 'Revisar dieta y hábitos alimenticios');

-- Registros para la entidad "dia_libre"
-- CODIGO | FECHA | MEDICO_CODIGO
insert into dia_libre values(1, '2023-10-07', 3);
insert into dia_libre values(2, '2023-10-09', 6);
insert into dia_libre values(3, '2023-10-11', 1);
insert into dia_libre values(4, '2023-10-12', 8);
insert into dia_libre values(5, '2023-10-14', 5);
insert into dia_libre values(6, '2023-10-17', 9);
insert into dia_libre values(7, '2023-10-19', 2);
insert into dia_libre values(8, '2023-10-21', 7);
insert into dia_libre values(9, '2023-10-24', 4);
insert into dia_libre values(10, '2023-10-26', 10);

-- Registros para la entidad "horario_medico"
-- CODIGO | HORA_FIN | HORA_INICIO | MEDICO_CODIGO | DIA
insert into horario_medico values(1, '14:00:00', '09:00:00', 3, 'VIERNES');
insert into horario_medico values(2, '15:00:00', '08:00:00', 6, 'DOMINGO');
insert into horario_medico values(3, '18:00:00', '07:00:00', 1, 'DOMINGO');
insert into horario_medico values(4, '17:30:00', '10:00:00', 8, 'SABADO');
insert into horario_medico values(5, '14:30:00', '10:30:00', 5, 'MIERCOLES');
insert into horario_medico values(6, '16:00:00', '10:30:00', 9, 'JUEVES');
insert into horario_medico values(7, '13:30:00', '09:30:00', 3, 'LUNES');
insert into horario_medico values(8, '19:00:00', '08:00:00', 3, 'MARTES');
insert into horario_medico values(9, '18:30:00', '06:30:00', 4, 'VIERNES');
insert into horario_medico values(10, '17:00:00', '07:00:00', 10, 'LUNES');

-- Registros para la entidad "incapacidad"
-- ATENCION_CODIGO | CODIGO | FECHA_FIN | FECHA_INICIO | MOTIVO
insert into incapacidad values(3, 1, '2023-10-07', '2023-10-27', 'Dolor de espalda');
insert into incapacidad values(5, 2,'2023-10-07', '2023-10-10', 'Gripe severa');
insert into incapacidad values(7, 3, '2023-10-08', '2023-10-18', 'Fiebre alta');
insert into incapacidad values(1, 4, '2023-10-08', '2023-11-20', 'Fractura de brazo');
insert into incapacidad values(8, 5, '2023-10-09', '2023-10-14', 'Dolor abdominal');
insert into incapacidad values(4, 6, '2023-10-09', '2023-10-21', 'Infección en la piel');
insert into incapacidad values(6, 7, '2023-10-10', '2023-10-11', 'Problemas digestivos');
insert into incapacidad values(10, 8, '2023-10-10', '2023-10-19', 'Dolor de muelas');
insert into incapacidad values(2, 9, '2023-10-11', '2023-10-25', 'Presión arterial alta');
insert into incapacidad values(9, 10, '2023-10-11', '2023-10-30', 'Problemas de ansiedad');

-- Registros para la entidad "medicamento"
-- CANTIDAD | CODIGO | VIA_ADMINISTRACION | DOSIS | NOMBRE
insert into medicamento values(10, 1, 'Oral', '1 comprimido cada 8 horas', 'Paracetamol');
insert into medicamento values(20, 2, 'Oral', '1 tableta cada 12 horas', 'Ibuprofeno');
insert into medicamento values(30, 3, 'Oral', '2 cápsulas cada 6 horas', 'Amoxicilina');
insert into medicamento values(40, 4, 'Oral', '1 comprimido cada 4 horas', 'Omeprazol');
insert into medicamento values(50, 5, 'Oral', '1 tableta cada 24 horas', 'Simvastatina');
insert into medicamento values(60, 6, 'Oral', '1 tableta cada 8 horas', 'Losartán');
insert into medicamento values(70, 7, 'Oral', '1 comprimido cada 6 horas', 'Metformina');
insert into medicamento values(80, 8, 'Oral', '1 tableta cada 12 horas', 'Diazepam');
insert into medicamento values(90, 9, 'Oral', '1 cápsula cada 8 horas', 'Ciprofloxacino');
insert into medicamento values(10, 10, 'Oral', '1 comprimido cada 24 horas', 'Loratadina');

-- Registros para la entidad "receta_medica"
-- ATENCION_CODIGO | CODIGO | DESCRIPCION
insert into receta_medica values(3, 1, 'Tomar Paracetamol cada 8 horas durante 3 días.');
insert into receta_medica values(5, 2, 'Tomar Ibuprofeno cada 12 horas durante 2 días.');
insert into receta_medica values(7, 3, 'Tomar Amoxicilina cada 6 horas durante 5 días.');
insert into receta_medica values(1, 4, 'Tomar Omeprazol cada 4 horas durante 7 días.');
insert into receta_medica values(8, 5, 'Tomar Simvastatina una vez al día durante 30 días.');
insert into receta_medica values(4, 6, 'Tomar Losartán cada 8 horas durante 10 días.');
insert into receta_medica values(6, 7, 'Tomar Metformina cada 6 horas durante 15 días.');
insert into receta_medica values(10, 8, 'Tomar Diazepam cada 12 horas según necesidad.');
insert into receta_medica values(2, 9, 'Tomar Ciprofloxacino cada 8 horas durante 7 días.');
insert into receta_medica values(9, 10, 'Tomar Loratadina una vez al día durante 5 días.');

-- Registros para la entidad "medicamento_receta"
-- MEDICAMENTO_CODIGO | RECETA_CODIGO
insert into medicamento_receta values(1, 1);
insert into medicamento_receta values(2, 2);
insert into medicamento_receta values(3, 3);
insert into medicamento_receta values(4, 4);
insert into medicamento_receta values(5, 5);
insert into medicamento_receta values(6, 6);
insert into medicamento_receta values(7, 7);
insert into medicamento_receta values(8, 8);
insert into medicamento_receta values(9, 9);
insert into medicamento_receta values(10, 10);