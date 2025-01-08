-- Insertar Profesores
INSERT INTO profesor (email, nombre) VALUES
                                         ('juan.perez@iesJandula.es', 'Juan Pérez'),
                                         ('maria.gomez@iesJandula.es', 'María Gómez'),
                                         ('luis.martinez@iesJandula.es', 'Luis Martínez'),
                                         ('ana.lopez@iesJandula.es', 'Ana López'),
                                         ('carlos.fernandez@iesJandula.es', 'Carlos Fernández');

-- Insertar Horarios para cada profesor
-- Asignar un horario completo para cada profesor (Lunes-Viernes, Primera-Sexta hora)

-- Horarios para Juan Pérez
INSERT INTO horario (profesor_email, dia_semana, hora_dia, actividad, aula_nombre) VALUES
                                                                                       ('juan.perez@iesJandula.es', 'LUNES', 'PRIMERA', 'CLASE', 'Aula 101'),
                                                                                       ('juan.perez@iesJandula.es', 'LUNES', 'SEGUNDA', 'GUARDIA', 'Sala Profesores'),
                                                                                       ('juan.perez@iesJandula.es', 'LUNES', 'TERCERA', 'SALA_PROFESORES', 'Sala Reuniones'),
                                                                                       ('juan.perez@iesJandula.es', 'LUNES', 'CUARTA', 'CLASE', 'Aula 102'),
                                                                                       ('juan.perez@iesJandula.es', 'LUNES', 'QUINTA', 'GUARDIA', 'Sala Profesores'),
                                                                                       ('juan.perez@iesJandula.es', 'LUNES', 'SEXTA', 'SALA_PROFESORES', 'Sala Reuniones'),
                                                                                       ('juan.perez@iesJandula.es', 'MARTES', 'PRIMERA', 'CLASE', 'Aula 201'),
                                                                                       ('juan.perez@iesJandula.es', 'MARTES', 'SEGUNDA', 'GUARDIA', 'Sala Profesores'),
                                                                                       ('juan.perez@iesJandula.es', 'MARTES', 'TERCERA', 'SALA_PROFESORES', 'Sala Reuniones'),
                                                                                       ('juan.perez@iesJandula.es', 'MARTES', 'CUARTA', 'CLASE', 'Aula 202'),
                                                                                       ('juan.perez@iesJandula.es', 'MARTES', 'QUINTA', 'GUARDIA', 'Sala Profesores'),
                                                                                       ('juan.perez@iesJandula.es', 'MARTES', 'SEXTA', 'SALA_PROFESORES', 'Sala Reuniones'),
                                                                                       ('juan.perez@iesJandula.es', 'MIERCOLES', 'PRIMERA', 'CLASE', 'Aula 301'),
                                                                                       ('juan.perez@iesJandula.es', 'MIERCOLES', 'SEGUNDA', 'GUARDIA', 'Sala Profesores'),
                                                                                       ('juan.perez@iesJandula.es', 'MIERCOLES', 'TERCERA', 'SALA_PROFESORES', 'Sala Reuniones'),
                                                                                       ('juan.perez@iesJandula.es', 'MIERCOLES', 'CUARTA', 'CLASE', 'Aula 302'),
                                                                                       ('juan.perez@iesJandula.es', 'MIERCOLES', 'QUINTA', 'GUARDIA', 'Sala Profesores'),
                                                                                       ('juan.perez@iesJandula.es', 'MIERCOLES', 'SEXTA', 'SALA_PROFESORES', 'Sala Reuniones'),
                                                                                       ('juan.perez@iesJandula.es', 'JUEVES', 'PRIMERA', 'CLASE', 'Aula 401'),
                                                                                       ('juan.perez@iesJandula.es', 'JUEVES', 'SEGUNDA', 'GUARDIA', 'Sala Profesores'),
                                                                                       ('juan.perez@iesJandula.es', 'JUEVES', 'TERCERA', 'SALA_PROFESORES', 'Sala Reuniones'),
                                                                                       ('juan.perez@iesJandula.es', 'JUEVES', 'CUARTA', 'CLASE', 'Aula 402'),
                                                                                       ('juan.perez@iesJandula.es', 'JUEVES', 'QUINTA', 'GUARDIA', 'Sala Profesores'),
                                                                                       ('juan.perez@iesJandula.es', 'JUEVES', 'SEXTA', 'SALA_PROFESORES', 'Sala Reuniones'),
                                                                                       ('juan.perez@iesJandula.es', 'VIERNES', 'PRIMERA', 'CLASE', 'Aula 501'),
                                                                                       ('juan.perez@iesJandula.es', 'VIERNES', 'SEGUNDA', 'GUARDIA', 'Sala Profesores'),
                                                                                       ('juan.perez@iesJandula.es', 'VIERNES', 'TERCERA', 'SALA_PROFESORES', 'Sala Reuniones'),
                                                                                       ('juan.perez@iesJandula.es', 'VIERNES', 'CUARTA', 'CLASE', 'Aula 502'),
                                                                                       ('juan.perez@iesJandula.es', 'VIERNES', 'QUINTA', 'GUARDIA', 'Sala Profesores'),
                                                                                       ('juan.perez@iesJandula.es', 'VIERNES', 'SEXTA', 'SALA_PROFESORES', 'Sala Reuniones');

-- Repite los horarios para los demás profesores
INSERT INTO horario (profesor_email, dia_semana, hora_dia, actividad, aula_nombre)
SELECT 'maria.gomez@iesJandula.es', dia_semana, hora_dia, actividad, aula_nombre FROM horario WHERE profesor_email = 'juan.perez@iesJandula.es';

INSERT INTO horario (profesor_email, dia_semana, hora_dia, actividad, aula_nombre)
SELECT 'luis.martinez@iesJandula.es', dia_semana, hora_dia, actividad, aula_nombre FROM horario WHERE profesor_email = 'juan.perez@iesJandula.es';

INSERT INTO horario (profesor_email, dia_semana, hora_dia, actividad, aula_nombre)
SELECT 'ana.lopez@iesJandula.es', dia_semana, hora_dia, actividad, aula_nombre FROM horario WHERE profesor_email = 'juan.perez@iesJandula.es';

INSERT INTO horario (profesor_email, dia_semana, hora_dia, actividad, aula_nombre)
SELECT 'carlos.fernandez@iesJandula.es', dia_semana, hora_dia, actividad, aula_nombre FROM horario WHERE profesor_email = 'juan.perez@iesJandula.es';
