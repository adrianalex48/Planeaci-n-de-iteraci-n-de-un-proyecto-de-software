# Planeación de una Iteración con Extreme Programming (XP)

---

## 1. Datos generales de la iteración

| Campo | Valor                                 |
|---|---------------------------------------|
| **Proyecto** | Selección de historias para iteración |
| **Número de iteración** | 1                                     |
| **Fecha de inicio** | 02 de septiembre de 2026              |
| **Fecha de término** | 09 de septiembre de 2026              |
| **Duración** | Una semana                            |
| **Cliente / Product Owner** | René Francisco Navarro Hernández      |

### Integrantes del equipo

| Integrante  | Rol o responsabilidad principal |
|-------------|---|
| Mendivil M. | Project Manager |
| Ojeda M.    | Developer |
|             | |
|             | |

---
## 2. Objetivo de la iteración
**Objetivo:**
> Entregar una versión funcional en Java que permita al usuario capturar manualmente un conjunto de valores numéricos, validarlos, elegir entre población o muestra, y obtener la desviación estándar junto con la media y el número de observaciones, con pruebas automatizadas que verifiquen el resultado en ambos denominadores.



<br>

---

## 3. Situación actual del proyecto

### Funcionalidades disponibles al inicio de la iteración
El proyecto inicia desde cero
<br>

### Problemas o restricciones conocidas
- El equipo es de dos personas con disponibilidad limitada.
- La iteración es de una semana no hay posibilidad de grandes cambios.
- No se han definido algunas funcionalidades. Por ejemplo, si solo funcionará en consola.
<br>

### Deuda técnica identificada
No aplica.
<br>

---

## 4. Historias de usuario candidatas

> Registrar todas las historias consideradas para la iteración.

| ID | Historia de usuario | Prioridad | Estimación | Dependencias |
|---|---|---|---|---|
| HU-01 | Como usuario, quiero cargar un archivo CSV con datos numéricos, para calcular su desviación estándar sin capturar los valores manualmente. | Media | 5 | HU-04, HU-06 |
| HU-02 | Como usuario, quiero seleccionar la columna del CSV que contiene los datos a analizar, para calcular sobre la variable de interés. | Media | 5 | HU-01 |
| HU-03 | Como usuario, quiero introducir manualmente un conjunto de valores numéricos, para calcular la desviación estándar cuando no disponga de un CSV. | Alta | 3 | — |
| HU-04 | Como usuario, quiero que el sistema valide los datos antes del cálculo, para evitar resultados incorrectos. | Alta | 5 | HU-03 |
| HU-05 | Como usuario, quiero indicar si los datos son población o muestra, para que se aplique la fórmula correcta. | Alta | 2 | — |
| HU-06 | Como usuario, quiero calcular la desviación estándar del conjunto seleccionado, para conocer la dispersión de los valores. | Alta | 3 | HU-04, HU-05 |
| HU-07 | Como usuario, quiero visualizar la media y el número de observaciones junto con la desviación estándar, para interpretar mejor el resultado. | Alta | 2 | HU-06 |
| HU-08 | Como usuario, quiero ver los datos que serán utilizados antes del cálculo, para verificar que el conjunto es correcto. | Media | 3 | HU-03 |
| HU-09 | Como usuario, quiero recibir mensajes claros cuando existan datos inválidos, para corregirlos antes del cálculo. | Baja | 2 | HU-04 |
| HU-10 | Como usuario, quiero limpiar los datos actuales y comenzar un nuevo cálculo, para analizar distintos conjuntos en una misma sesión. | Baja | 2 | HU-06 |

---

## 5. Selección de historias para la iteración

> Elegimos las historias que juntas forman un programa completo aunque chiquito, en vez de cinco pedazos que por separado no sirven.

| ID | Historia | Prioridad | Estimación | Seleccionada |
|---|---|---|---|---|
| HU-03 | Captura manual de valores | Alta | 3 | ☑ |
| HU-04 | Validación de datos | Alta | 5 | ☑ |
| HU-05 | Selección población / muestra | Alta | 2 | ☑ |
| HU-06 | Cálculo de desviación estándar | Alta | 3 | ☑ |
| HU-07 | Visualización de media y N | Alta | 2 | ☑ |

### Capacidad estimada del equipo

- **Capacidad disponible:** 14 horas-persona (2 integrantes × 7 días × 1 hora diaria), equivalentes a 7 horas de trabajo en pareja.
- **Esfuerzo total comprometido:** 14 horas-persona

**¿El trabajo comprometido corresponde razonablemente con la capacidad del equipo?**

☑ Sí  ☐ No

**Justificación:**
El compromiso coincide con la capacidad disponible, sin margen para imprevistos. Se acepta porque las cinco historias comparten el mismo núcleo de código. Si el tiempo se agota, HU-07 es la historia más pequeña y la última de la cadena de dependencias, por lo que es la primera en recortarse.
<br>

---

## 6. Detalle de historias de usuario

### Historia HU-03 - Captura manual de valores


**Como** usuario
**quiero** introducir manualmente un conjunto de valores numéricos
**para** calcular la desviación estándar cuando no disponga de un archivo CSV.

#### Criterios de aceptación

- [ ] Permite introducir múltiples valores en una misma sesión de captura.
- [ ] Acepta números enteros y decimales (positivos y negativos).
- [ ] Rechaza entradas no numéricas sin terminar el programa.
- [ ] Existe una forma explícita de indicar que la captura terminó.

#### Casos de prueba iniciales

> 💡 **Nota:** ¿Con qué condición evalúas la historia del usuario? Ejemplo: probar la introducción de datos no numéricos.

| Caso | Entrada / Condición | Resultado esperado                                                               |
|---|---|----------------------------------------------------------------------------------|
| CP-01 | Se capturan `4`, `8`, `15`, `16` y se finaliza | La lista contiene 4 elementos en el mismo orden                                  |
| CP-02 | Se captura `3.75` | El valor se almacena como decimal.                                               |
| CP-03 | Se captura `abc` | Se muestra mensaje de error y se solicita el valor de nuevo y la lista no cambia |
| CP-04 | Se captura `-2.5` | El valor se acepta como negativo.                                                |
| CP-05 | Se finaliza la captura sin introducir nada | La lista queda vacía.                                                            |

#### Tareas técnicas

> 💡 **Nota:** Esta sección se puede saltar.

| ID | Tarea | Responsable / Pareja | Estado |
|---|-------|---|---|
| T-01 | NULL  | | Pendiente |
| T-02 | NULL  | | Pendiente |
| T-03 | NULL  | | Pendiente |

#### Consideraciones técnicas

<br>

---

## 7. Planeación de Test-Driven Development (TDD)

> 💡 **Nota:** Se va llenando conforme se avanza en la aplicación de las pruebas.

Para cada funcionalidad importante, definir al menos los primeros casos de prueba **antes** de implementar el código.

| Historia | Prueba | Comportamiento esperado | Estado |
|---|---|---|---|
| | | | ☐ RED ☐ GREEN ☐ REFACTOR |
| | | | ☐ RED ☐ GREEN ☐ REFACTOR |
| | | | ☐ RED ☐ GREEN ☐ REFACTOR |
| | | | ☐ RED ☐ GREEN ☐ REFACTOR |

### Ciclo esperado: `RED → GREEN → REFACTOR`

| Fase | Descripción |
|---|---|
| **RED** | Escribir una prueba que inicialmente falle. |
| **GREEN** | Implementar el código mínimo necesario para hacer pasar la prueba. |
| **REFACTOR** | Mejorar el diseño del código sin modificar su comportamiento. |

---

## 8. Planeación de Pair Programming

> 💡 **Nota:** Intercambiar los roles de Project Manager.

| Pareja | Driver | Navigator | Historia / tarea |
|---|---|---|---|
| 1 | Ojeda | Mendivil | HU-03, HU-04 |
| 1 | Mendivil | Ojeda | HU-05, HU-06 |
| 1 | Ojeda | Mendivil | HU-07 e integración final |

- **Frecuencia de cambio de roles:** cada sesión.
- **Frecuencia de rotación de parejas:** no aplica.

---

## 9. Estándares de codificación

Durante la iteración el equipo utilizará los siguientes estándares:

- [ ] Convenciones de nomenclatura
- [ ] Formato e indentación uniforme
- [ ] Métodos con una responsabilidad claramente definida
- [ ] Evitar duplicación
- [ ] Uso de constantes para valores significativos
- [ ] Manejo adecuado de excepciones
- [ ] Documentación mediante Javadoc cuando corresponda
- [ ] Pruebas automatizadas
- [ ] Estándar de commits

### Reglas adicionales

> 💡 **Nota:** Alguna otra convención definida para saber cómo vamos a trabajar.

Los nombres de clases, métodos y variables se escriben en español, sin acentos ni eñes en los identificadores.
<br>

---

## 10. Estrategia de control de versiones

> 💡 **Nota:** Nombre del repositorio.

- **Repositorio:** https://github.com/adrianalex48/Planeaci-n-de-iteraci-n-de-un-proyecto-de-software
- **Rama principal:** \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_

### Convención para ramas

```
feature/nombre-funcionalidad
fix/nombre-error
```

### Convención para mensajes de commit

Los commits deberán:

- Representar cambios pequeños y coherentes.
- Utilizar mensajes descriptivos.
- Evitar mezclar funcionalidades no relacionadas.

**Ejemplo:**

```
Agregar cálculo de desviación estándar
```

> ⚠️ **Importante:** Hacer commits para no hacer trampa.

---

## 11. Integración continua

> 💡 **Nota:** Palomear.

Definir qué deberá verificarse antes de integrar cambios:

- [ ] El proyecto compila correctamente.
- [ ] Todas las pruebas automatizadas pasan.
- [ ] No se introducen errores conocidos.
- [ ] El código cumple los estándares establecidos.
- [ ] Se realizó revisión de código.
- [ ] La nueva funcionalidad satisface sus criterios de aceptación.

**Frecuencia de integración:**

<br>

---

## 12. Refactoring previsto

> 💡 **Nota:** Ver si se puede mejorar.

| Componente | Problema identificado | Refactoring propuesto | Prioridad |
|---|---|---|---|
| | | | |
| | | | |
| | | | |

> La refactorización deberá realizarse **manteniendo exitosas las pruebas automatizadas**.

---

## 13. Riesgos de la iteración

| Riesgo | Probabilidad | Impacto | Acción preventiva |
|---|---|---|---|
| | Alta / Media / Baja | Alto / Medio / Bajo | |
| | | | |
| | | | |
| | | | |

---

## 14. Seguimiento diario



| Día | Trabajo realizado       | Problemas encontrados   | Próximo trabajo        |
|---|-------------------------|-------------------------|------------------------|
| 1 | Planeación del programa | Distribución de tiempos | Elaboración del código |
| 2 |                         |                         |                        |
| 3 |                         |                         |                        |
| 4 |                         |                         |                        |
| 5 |                         |                         |                        |

---

## 15. Cambios solicitados durante la iteración

> 💡 **Nota:** Aquí se registra la introducción de features nuevas.

XP acepta que los requerimientos pueden cambiar. Registrar los cambios solicitados y la decisión del equipo.

| Fecha | Cambio solicitado | Historia afectada | Decisión |
|---|---|---|---|
| | | | |
| | | | |
| | | | |

### Decisiones posibles

- Incorporar en la iteración actual.
- Intercambiar por otra historia.
- Posponer para la siguiente iteración.
- Rechazar por no aportar valor suficiente.

---

## 16. Criterios de finalización de una historia

Una historia podrá considerarse terminada cuando:

- [ ] Cumple todos los criterios de aceptación.
- [ ] Las pruebas automatizadas son satisfactorias.
- [ ] Se realizó refactoring cuando fue necesario.
- [ ] El código cumple los estándares acordados.
- [ ] El código fue integrado en la rama correspondiente.
- [ ] No existen errores conocidos críticos.
- [ ] El cliente o responsable funcional acepta el resultado.

---

## 17. Resultado de la iteración

> 💡 **Nota:** Las historias que terminamos, en cuánto tiempo, cuánto avanzamos y qué necesitamos.

### Historias terminadas

| Historia | Estado | Resultado |
|----------|---|---|
| 0        | Terminada | |
| 0        | Terminada | |
| 0        | Terminada | |

### Historias no terminadas

| Historia | Avance | Razón | Acción siguiente |
|---|---|---|---|
| | % | | |
| | % | | |

---

## 18. Retroalimentación del cliente

> 💡 **Nota:** Omitir.

**Funcionalidades presentadas:**

<br>

**Comentarios del cliente:**

<br>

**Cambios solicitados:**

<br>

---

## 19. Métricas de la iteración

> ⚠️ **Importante:** Debemos terminar 5 historias.

| Métrica | Resultado |
|---|---|
| Historias comprometidas | |
| Historias terminadas | |
| Puntos comprometidos | |
| Puntos completados | |
| Pruebas automatizadas | |
| Pruebas exitosas | |
| Defectos encontrados | |
| Defectos corregidos | |
| Commits realizados | |
| Integraciones realizadas | |

---

## 20. Retrospectiva

### ¿Qué funcionó bien?

<br>

### ¿Qué problemas encontramos?

<br>

### ¿Qué debemos mejorar en la siguiente iteración?

<br>

**Acción de mejora prioritaria:**

**Responsable:** \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_

---

## 21. Planeación preliminar de la siguiente iteración

### Historias candidatas

| ID | Historia | Prioridad |
|---|---|---|
| HU-01 | Cargar archivo CSV con datos numéricos | Alta |
| HU-02 | Seleccionar la columna del CSV a analizar | Alta |
| HU-08 | Vista previa de los datos antes del cálculo | Media |
| HU-09 | Mensajes claros ante datos inválidos | Baja |
| HU-10 | Limpiar datos y comenzar un nuevo cálculo | Baja |

**Deuda técnica pendiente:**

<br>

**Nuevas necesidades identificadas:**

<br>

---

## Lista de verificación XP de la iteración

Antes de finalizar, verificar cuáles prácticas de XP fueron utilizadas:

- [ ] Planning Game / planeación mediante historias
- [ ] User Stories
- [ ] Small Releases
- [ ] Pair Programming
- [ ] Test-Driven Development
- [ ] Refactoring
- [ ] Simple Design
- [ ] Continuous Integration
- [ ] Collective Code Ownership
- [ ] Coding Standards
- [ ] Retroalimentación frecuente del cliente

---

## Reflexión final

**¿De qué manera las prácticas de XP ayudaron al equipo a responder a cambios y mantener la calidad del software durante esta iteración?**

<br>
