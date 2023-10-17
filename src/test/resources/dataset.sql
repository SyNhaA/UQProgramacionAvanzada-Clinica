-- Registros para la entidad "cuenta"
-- CODIGO | EMAIL | CONTRASEÑA
insert into cuenta values(1, 'pepito@email.com', '123');
insert into cuenta values(2, 'juanita@email.com', '234');
insert into cuenta values(3, 'carlos@email.com', '345');
insert into cuenta values(4, 'laura@email.com', '456');
insert into cuenta values(5, 'roberto@email.com', '567');
insert into cuenta values(6, 'ana@email.com', '678');
insert into cuenta values(7, 'maria@email.com', '789');
insert into cuenta values(8, 'pedro@email.com', '890');
insert into cuenta values(9, 'sara@email.com', '901');
insert into cuenta values(10, 'david@email.com', '012');

-- Registros para la entidad "administrador"
-- CODIGO
insert into administrador values(1);
insert into administrador values(2);
insert into administrador values(3);
insert into administrador values(4);

-- Registros para la entidad "paciente"
-- CODIGO | ESTADO | FECHA_NACIMIENTO | CEDULA | TELEFONO | NOMBRE | URL_FOTO | CIUDAD | EPS | TIPO_SANGRE
insert into paciente values(1, 'ACTIVO', '1990-05-15 00:00:00', '1', '555-111', 'Juan Perez', 'https://url_foto1.com', 'ARMENIA', 'COMFENALCO', 'A_POSITIVO');
insert into paciente values(2, 'ACTIVO', '1985-09-20 00:00:00', '2', '555-222', 'Laura Garcia', 'https://url_foto2.com', 'BOGOTA', 'COMPENSAR', 'B_NEGATIVO');
insert into paciente values(3, 'ACTIVO', '1992-03-10 00:00:00', '3', '555-333', 'Carlos Rodriguez', 'https://url_foto3.com', 'CALARCA', 'COOMEVA', 'O_POSITIVO');
insert into paciente values(4, 'ACTIVO', '1988-07-25 00:00:00', '4', '555-444', 'Ana Martinez', 'https://url_foto4.com', 'CALI', 'FAMISANAR', 'A_NEGATIVO');
insert into paciente values(5, 'ACTIVO', '1980-11-05 00:00:00', '5', '555-555', 'Sara Lopez', 'https://url_foto5.com', 'CIRCASIA', 'MEDIMAS', 'AB_POSITIVO');
insert into paciente values(6, 'ACTIVO', '1975-02-18 00:00:00', '6', '555-666', 'Pedro Torres', 'https://url_foto6.com', 'DOSQUEBRADAS', 'NUEVA_EPS', 'B_POSITIVO');
insert into paciente values(7, 'ACTIVO', '1995-12-30 00:00:00', '7', '555-777', 'Maria Gonzalez', 'https://url_foto7.com', 'IBAGUE', 'SALUD_TOTAL', 'AB_NEGATIVO');
insert into paciente values(8, 'ACTIVO', '1987-06-14 00:00:00', '8', '555-888', 'Roberto Sanchez', 'https://url_foto8.com', 'MANIZALES', 'SANITAS', 'O_NEGATIVO');
insert into paciente values(9, 'ACTIVO', '1991-04-03 00:00:00', '9', '555-999', 'Luis Fernandez', 'https://url_foto9.com', 'PEREIRA', 'SURA', 'A_POSITIVO');
insert into paciente values(10, 'ACTIVO', '1983-08-08 00:00:00', '10', '555-000', 'Julia Ramírez', 'https://url_foto10.com', 'SALENTO', 'SURA', 'B_NEGATIVO');

-- Registros para la entidad "medico"
-- CODIGO | ESTADO | CEDULA | TELEFONO | NOMBRE | URL_FOTO | CIUDAD | ESPECIALIDAD
insert into medico values(1, 'ACTIVO', '1989678967', '555-123', 'Dr. Rodriguez', 'https://url_foto1.com', 'ARMENIA', 'CARDIOLOGIA');
insert into medico values(2, 'ACTIVO', '3214567890', '555-234', 'Dra. Perez', 'https://url_foto2.com', 'BOGOTA', 'DERMATOLOGIA');
insert into medico values(3, 'ACTIVO', '7890123456', '555-345', 'Dr. Gómez', 'https://url_foto3.com', 'CALARCA', 'ENDOCRINOLOGIA');
insert into medico values(4, 'ACTIVO', '4567890123', '555-456', 'Dra. Lopez', 'https://url_foto4.com', 'CALI', 'GASTROENTEROLOGIA');
insert into medico values(5, 'ACTIVO', '2345678901', '555-567', 'Dr. Martinez', 'https://url_foto5.com', 'CIRCASIA', 'GINECOLOGIA');
insert into medico values(6, 'ACTIVO', '8901234567', '555-678', 'Dra. Fernandez', 'https://url_foto6.com', 'DOSQUEBRADAS', 'MEDICINA_GENERAL');
insert into medico values(7, 'ACTIVO', '5678901234', '555-789', 'Dr. Ramirez', 'https://url_foto7.com', 'IBAGUE', 'NEUROLOGIA');
insert into medico values(8, 'ACTIVO', '3456789012', '555-890', 'Dra. Sanchez', 'https://url_foto8.com', 'MANIZALES', 'OFTALMOLOGIA');
insert into medico values(9, 'ACTIVO', '1234567890', '555-901', 'Dr. Torres', 'https://url_foto9.com', 'PEREIRA', 'OTORRINOLARINGOLOGIA');
insert into medico values(10, 'ACTIVO', '6789012345', '555-012', 'Dra. Gonzalez', 'https://url_foto10.com', 'SALENTO', 'PEDIATRIA');

-- Registros para la entidad "cita"
-- CODIGO | MEDICO_CODIGO | PACIENTE_CODIGO | FECHA_CITA | FECHA_CREACION | MOTIVO | ESTADO (CANCELADA, COMPLETADA, PROGRAMADA)
insert into cita values(1, 3, 8, '2023-10-06 09:30:00', '2023-10-05 08:00:00', 'Consulta médica', 'CANCELADA');
insert into cita values(2, 6, 1, '2023-10-06 11:15:00', '2023-10-05 09:20:00', 'Examen de rutina', 'CANCELADA');
insert into cita values(3, 9, 4, '2023-10-06 13:00:00', '2023-10-05 10:45:00', 'Control de medicación', 'CANCELADA');
insert into cita values(4, 2, 7, '2023-10-06 15:45:00', '2023-10-05 12:30:00', 'Seguimiento postoperatorio', 'CANCELADA');
insert into cita values(5, 5, 10, '2023-10-06 17:30:00', '2023-10-05 14:15:00', 'Evaluación dental', 'CANCELADA');
insert into cita values(6, 8, 2, '2023-10-06 09:00:00', '2023-10-05 15:05:00', 'Terapia física', 'CANCELADA');
insert into cita values(7, 10, 5, '2023-10-06 11:30:00', '2023-10-05 16:40:00', 'Consulta psicológica', 'CANCELADA');
insert into cita values(8, 4, 9, '2023-10-06 14:15:00', '2023-10-05 17:55:00', 'Control de embarazo', 'CANCELADA');
insert into cita values(9, 1, 3, '2023-10-06 16:00:00', '2023-10-05 19:20:00', 'Chequeo de laboratorio', 'CANCELADA');
insert into cita values(10, 7, 6, '2023-10-06 18:45:00', '2023-10-05 20:10:00', 'Consulta de alergias', 'CANCELADA');

-- Registros para la entidad "pqrs"
-- CODIGO | CODIGO_CITA | FECHA_CREACION | MOTIVO | ESTADO (ARCHIVADO, EN_PROCESO, NUEVO, RESUELTO)
insert into pqrs values(1, 4, '2023-10-05 08:30:00', 'Consulta sobre factura', 'ARCHIVADO');
insert into pqrs values(2, 8, '2023-10-05 10:45:00', 'Reclamo por servicio', 'ARCHIVADO');
insert into pqrs values(3, 1, '2023-10-05 13:15:00', 'Solicitud de información', 'EN_PROCESO');
insert into pqrs values(4, 5, '2023-10-05 15:40:00', 'Queja sobre producto', 'NUEVO');
insert into pqrs values(5, 9, '2023-10-05 17:55:00', 'Reporte de fallo', 'RESUELTO');
insert into pqrs values(6, 2, '2023-10-05 19:20:00', 'Reclamo por demora', 'RESUELTO');
insert into pqrs values(7, 6, '2023-10-05 08:50:00', 'Solicitud de reembolso', 'EN_PROCESO');
insert into pqrs values(8, 10, '2023-10-05 11:10:00', 'Consulta técnica', 'NUEVO');
insert into pqrs values(9, 3, '2023-10-05 14:30:00', 'Queja sobre atención', 'RESUELTO');
insert into pqrs values(10, 7, '2023-10-05 16:45:00', 'Reclamo por error', 'RESUELTO');

-- Registros para la entidad "mensaje"
-- CODIGO | FECHA_CREACION | MENSAJE | CUENTA_CODIGO | PQRS_CODIGO | RESPUESTA_CODIGO
insert into mensaje values(1, 2, null, 2, '2023-10-05 09:00:00', 'Hola, buenos dias');
insert into mensaje values(2, 2, 1, 4, '2023-10-05 10:30:00', 'Hola, ¿cómo estas?');
insert into mensaje values(3, 2, 2, 1, '2023-10-05 14:15:00', 'Buenas tardes');
insert into mensaje values(4, 2, 3, 2, '2023-10-05 16:45:00', '¡Hola a todos!');
insert into mensaje values(5, 2, 4, 3, '2023-10-05 18:20:00', 'Saludos desde aqui');
insert into mensaje values(6, 2, 5, 5, '2023-10-05 20:10:00', 'Buenas noches');
insert into mensaje values(7, 2, 6, 3, '2023-10-05 09:45:00', 'Hola a cada uno');
insert into mensaje values(8, 2, 7, 2, '2023-10-05 11:30:00', 'Buenas mananas');
insert into mensaje values(9, 2, 8, 1, '2023-10-05 15:00:00', '¡Hola, hola!');
insert into mensaje values(10, 2, 9, 7, '2023-10-05 17:30:00', 'Saludos cordiales');

-- Registros para la entidad "atencion_medica"
-- CODIGO | CITA_CODIGO | DIAGNOSTICO | NOTAS | TRATAMIENTO
insert into atencion_medica values(1, 3, 'Fiebre y dolor de cabeza', 'Se recomienda reposo y tomar paracetamol', 'Paracetamol 500mg cada 6 horas');
insert into atencion_medica values(2, 5, 'Dolor abdominal', 'Se necesita hacer pruebas adicionales', 'Referir al especialista');
insert into atencion_medica values(3, 7, 'Presión arterial alta', 'Controlar la dieta y hacer ejercicio', 'Recetar medicamento antihipertensivo');
insert into atencion_medica values(4, 1, 'Fractura de brazo', 'Se necesita una radiografía', 'Inmovilizar el brazo y derivar a un ortopedista');
insert into atencion_medica values(5, 8, 'Dolor de muelas', 'Posible caries dental', 'Revisión y limpieza dental');
insert into atencion_medica values(6, 4, 'Dolor de espalda', 'Sugerir cambios en la postura y ejercicios', 'Recetar analgésicos y derivar a fisioterapia');
insert into atencion_medica values(7, 6, 'Problemas de ansiedad', 'Necesita consulta con psicólogo', 'Terapia cognitivo-conductual');
insert into atencion_medica values(8, 10, 'Gripe y fiebre', 'Reposo y mantenerse hidratado', 'Antigripales y paracetamol');
insert into atencion_medica values(9, 2, 'Infección en la piel', 'Tomar antibióticos', 'Aplicar crema antibiótica');
insert into atencion_medica values(10, 9, 'Problemas digestivos', 'Revisar dieta y hábitos alimenticios', 'Recomendar dieta y ejercicio regular');

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
-- CODIGO | DIA | HORA_FIN | HORA_INICIO | MEDICO_CODIGO
insert into horario_medico values(1, '10:15:25', '2:00:00', 3, 'DOMINGO');
insert into horario_medico values(2, '12:15:25', '18:00:00', 6, 'DOMINGO');
insert into horario_medico values(3, '12:15:25', '13:00:00', 1, 'DOMINGO');
insert into horario_medico values(4, '12:15:25', '19:00:00', 8, 'DOMINGO');
insert into horario_medico values(5, '12:15:25', '12:30:00', 5, 'DOMINGO');
insert into horario_medico values(6, '12:15:25', '18:30:00', 9, 'DOMINGO');
insert into horario_medico values(7, '12:15:25', '13:15:00', 2, 'DOMINGO');
insert into horario_medico values(8, '12:15:25', '19:15:00', 7, 'DOMINGO');
insert into horario_medico values(9, '12:15:25', '12:45:00', 4, 'DOMINGO');
insert into horario_medico values(10, '12:15:25', '18:45:00', 10, 'DOMINGO');

-- Registros para la entidad "incapacidad"
-- CODIGO | ATENCION_CODIGO | FECHA_FIN | FECHA_INICIO | MOTIVO
insert into incapacidad values(1, 3, '2023-10-07 12:00:00', '2023-10-07 08:00:00', 'Dolor de espalda');
insert into incapacidad values(2, 5, '2023-10-07 18:00:00', '2023-10-07 14:00:00', 'Gripe severa');
insert into incapacidad values(3, 7, '2023-10-08 13:00:00', '2023-10-08 09:00:00', 'Fiebre alta');
insert into incapacidad values(4, 1, '2023-10-08 19:00:00', '2023-10-08 15:00:00', 'Fractura de brazo');
insert into incapacidad values(5, 8, '2023-10-09 12:30:00', '2023-10-09 08:30:00', 'Dolor abdominal');
insert into incapacidad values(6, 4, '2023-10-09 18:30:00', '2023-10-09 14:30:00', 'Infección en la piel');
insert into incapacidad values(7, 6, '2023-10-10 13:15:00', '2023-10-10 09:15:00', 'Problemas digestivos');
insert into incapacidad values(8, 10, '2023-10-10 19:15:00', '2023-10-10 15:15:00', 'Dolor de muelas');
insert into incapacidad values(9, 2, '2023-10-11 12:45:00', '2023-10-11 08:45:00', 'Presión arterial alta');
insert into incapacidad values(10, 9, '2023-10-11 18:45:00', '2023-10-11 14:45:00', 'Problemas de ansiedad');

-- Registros para la entidad "medicamento"
-- CODIGO | CANTIDAD | VIA_ADMINISTRACION | DOSIS | NOMBRE
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
-- CODIGO | ATENCION_CODIGO | DESCRIPCION
insert into receta_medica values(1, 3, 'Tomar Paracetamol cada 8 horas durante 3 días.');
insert into receta_medica values(2, 5, 'Tomar Ibuprofeno cada 12 horas durante 2 días.');
insert into receta_medica values(3, 7, 'Tomar Amoxicilina cada 6 horas durante 5 días.');
insert into receta_medica values(4, 1, 'Tomar Omeprazol cada 4 horas durante 7 días.');
insert into receta_medica values(5, 8, 'Tomar Simvastatina una vez al día durante 30 días.');
insert into receta_medica values(6, 4, 'Tomar Losartán cada 8 horas durante 10 días.');
insert into receta_medica values(7, 6, 'Tomar Metformina cada 6 horas durante 15 días.');
insert into receta_medica values(8, 10, 'Tomar Diazepam cada 12 horas según necesidad.');
insert into receta_medica values(9, 2, 'Tomar Ciprofloxacino cada 8 horas durante 7 días.');
insert into receta_medica values(10, 9, 'Tomar Loratadina una vez al día durante 5 días.');

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

-- Registros para la entidad "paciente_alergias"
-- PACIENTE_CODIGO | ALERGIA
insert into paciente_alergias values(1, 'Alergia al polen');
insert into paciente_alergias values(2, 'Alergia a los gatos');
insert into paciente_alergias values(3, 'Alergia a los frutos secos');
insert into paciente_alergias values(4, 'Alergia al polvo');
insert into paciente_alergias values(5, 'Alergia al marisco');
insert into paciente_alergias values(6, 'Alergia al gluten');
insert into paciente_alergias values(7, 'Alergia a los ácaros');
insert into paciente_alergias values(8, 'Alergia al pelo de perro');
insert into paciente_alergias values(9, 'Alergia a la lactosa');
insert into paciente_alergias values(10, 'Alergia a las abejas');