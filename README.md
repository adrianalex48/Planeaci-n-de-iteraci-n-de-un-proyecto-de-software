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

- [x] Permite introducir múltiples valores en una misma sesión de captura.
- [x] Acepta números enteros y decimales (positivos y negativos).
- [x] Rechaza entradas no numéricas sin terminar el programa.
- [x] Existe una forma explícita de indicar que la captura terminó.

#### Casos de prueba iniciales

| Caso | Entrada / Condición | Resultado esperado |
|---|---|---|
| CP-01 | Se capturan `4`, `8`, `15`, `16` y se finaliza | La lista contiene 4 elementos en el mismo orden |
| CP-02 | Se captura `3.75` | El valor se almacena como decimal. |
| CP-03 | Se captura `abc` | Se muestra mensaje de error y se solicita el valor de nuevo y la lista no cambia |
| CP-04 | Se captura `-2.5` | El valor se acepta como negativo. |
| CP-05 | Se finaliza la captura sin introducir nada | La lista queda vacía. |

#### Tareas técnicas

| ID | Tarea | Responsable / Pareja | Estado |
|---|-------|---|---|
| T-01 | Clase `ConjuntoDatos` con almacenamiento en lista | Ojeda / Mendivil | Terminada |
| T-02 | Validación de entradas mediante `esNumeroValido` | Ojeda / Mendivil | Terminada |
| T-03 | Ciclo de captura en consola con palabra de término | Ojeda / Mendivil | Terminada |

#### Consideraciones técnicas

La captura se realiza mediante `Scanner` fijando `Locale.US`, ya que la configuración regional en español espera coma decimal y provoca `InputMismatchException` al leer valores como `3.75`. La validación se resuelve leyendo la entrada como cadena y convirtiéndola solo después de verificarla, de modo que una entrada no numérica no interrumpe el programa.
<br>

---

## 7. Planeación de Test-Driven Development (TDD)

Para cada funcionalidad importante, definir al menos los primeros casos de prueba **antes** de implementar el código.

| Historia | Prueba | Comportamiento esperado | Estado |
|---|---|---|---|
| HU-03 | `agregarVariosValores_almacenaEnOrden` | Conserva 4 elementos en el orden de captura | ☑ GREEN |
| HU-03 | `agregarDecimal_seAlmacenaCorrectamente` | Almacena 3.75 como valor decimal | ☑ GREEN |
| HU-04 | `esNumeroValido_conTextoNoNumerico_devuelveFalse` | Devuelve false ante una cadena no numérica | ☑ GREEN |
| HU-04 | `agregarValorInvalido_lanzaExcepcion` | Lanza `IllegalArgumentException` ante NaN | ☑ GREEN |
| HU-04 | `rechazaMuestraDeUnSoloDato` | Lanza `IllegalArgumentException` al pedir muestra con un dato | ☑ REFACTOR |
| HU-05 | `calculaDesviacionMuestral` | Con el conjunto de referencia devuelve 2.1381 | ☑ REFACTOR |
| HU-06 | `calculaDesviacionPoblacional` | Con el conjunto de referencia devuelve 2.0 | ☑ REFACTOR |
| HU-07 | `calculaLaMediaDelConjunto` | Con el conjunto de referencia devuelve 5.0 | ☑ REFACTOR |

### Ciclo esperado: `RED → GREEN → REFACTOR`

| Fase | Descripción |
|---|---|
| **RED** | Escribir una prueba que inicialmente falle. |
| **GREEN** | Implementar el código mínimo necesario para hacer pasar la prueba. |
| **REFACTOR** | Mejorar el diseño del código sin modificar su comportamiento. |

---

## 8. Planeación de Pair Programming

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

- [x] Convenciones de nomenclatura
- [x] Formato e indentación uniforme
- [x] Métodos con una responsabilidad claramente definida
- [x] Evitar duplicación
- [x] Uso de constantes para valores significativos
- [x] Manejo adecuado de excepciones
- [x] Documentación mediante Javadoc cuando corresponda
- [x] Pruebas automatizadas
- [ ] Estándar de commits

### Reglas adicionales

Los nombres de clases, métodos y variables se escriben en español, sin acentos ni eñes en los identificadores.
<br>

---

## 10. Estrategia de control de versiones

- **Repositorio:** https://github.com/adrianalex48/Planeaci-n-de-iteraci-n-de-un-proyecto-de-software
- **Rama principal:** `main`

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

Definir qué deberá verificarse antes de integrar cambios:

- [x] El proyecto compila correctamente.
- [x] Todas las pruebas automatizadas pasan.
- [x] No se introducen errores conocidos.
- [x] El código cumple los estándares establecidos.
- [x] Se realizó revisión de código.
- [x] La nueva funcionalidad satisface sus criterios de aceptación.

**Frecuencia de integración:** al cerrar cada ciclo RED–GREEN–REFACTOR, verificando en verde la totalidad de las pruebas antes de subir los cambios.
<br>

---

## 12. Refactoring previsto

| Componente | Problema identificado | Refactoring propuesto | Prioridad |
|---|---|---|---|
| `CalculadoraDesviacion` | Duplicación del ciclo de suma en media y desviación | Extraer método privado `varianza` | Alta |
| `CalculadoraDesviacion` | Mensajes de error y denominador mínimo como literales | Extraer constantes | Media |
| `CalculadoraDesviacion` | Validación repetida en dos métodos públicos | Extraer método privado `validar` | Media |
| `ConjuntoDatos` | Mensaje de valor inválido escrito directamente en el `throw` | Extraer constante `ERROR_VALOR_INVALIDO` | Baja |

> La refactorización deberá realizarse **manteniendo exitosas las pruebas automatizadas**.

---

## 13. Riesgos de la iteración

| Riesgo | Probabilidad | Impacto | Acción preventiva |
|---|---|---|---|
| División entre cero al calcular una muestra de un solo dato | Media | Alto | Prueba específica que exige lanzar excepción |
| Error de formato decimal por configuración regional | Alta | Medio | Fijar `Locale.US` en el `Scanner` |
| Capacidad sin margen para imprevistos | Alta | Medio | HU-07 identificada como la primera en recortarse |
| Entorno de pruebas sin JUnit configurado en el classpath | Media | Medio | Verificar la ejecución de las pruebas al inicio, antes de escribir código |

---

## 14. Seguimiento diario

| Día | Trabajo realizado | Problemas encontrados | Próximo trabajo |
|---|---|---|---|
| 1 | Planeación del programa | Distribución de tiempos | Elaboración del código |
| 2 | Clase `ConjuntoDatos` y sus pruebas de captura | Métodos duplicados dentro de la clase impedían compilar | Validación de entradas |
| 3 | Validación con `esNumeroValido` y rechazo de NaN | Pruebas escritas fuera de la llave de cierre de la clase | Cálculo de desviación estándar |
| 4 | Ciclo RED–GREEN de `CalculadoraDesviacion` | JUnit no estaba en el classpath del proyecto | Refactoring |
| 5 | Refactoring y clase `Main` de consola | Formato decimal por configuración regional | Integración final y documentación |

---

## 15. Cambios solicitados durante la iteración

XP acepta que los requerimientos pueden cambiar. Registrar los cambios solicitados y la decisión del equipo.

| Fecha | Cambio solicitado | Historia afectada | Decisión |
|---|---|---|---|
| 05/09/2026 | Rechazar explícitamente el cálculo de muestra con una sola observación en lugar de devolver un valor indefinido | HU-04, HU-05 | Incorporar en la iteración actual |

### Decisiones posibles

- Incorporar en la iteración actual.
- Intercambiar por otra historia.
- Posponer para la siguiente iteración.
- Rechazar por no aportar valor suficiente.

---

## 16. Criterios de finalización de una historia

Una historia podrá considerarse terminada cuando:

- [x] Cumple todos los criterios de aceptación.
- [x] Las pruebas automatizadas son satisfactorias.
- [x] Se realizó refactoring cuando fue necesario.
- [x] El código cumple los estándares acordados.
- [x] El código fue integrado en la rama correspondiente.
- [x] No existen errores conocidos críticos.
- [ ] El cliente o responsable funcional acepta el resultado.

---

## 17. Resultado de la iteración

### Historias terminadas

| Historia | Estado | Resultado |
|---|---|---|
| HU-03 | Terminada | Captura manual de valores enteros, decimales y negativos, con término explícito |
| HU-04 | Terminada | Validación de entradas no numéricas, conjunto vacío y muestra de un solo dato |
| HU-05 | Terminada | Selección entre población y muestra aplicando el denominador correspondiente |
| HU-06 | Terminada | Cálculo de la desviación estándar verificado en ambos denominadores |
| HU-07 | Terminada | Presentación de media, número de observaciones y tipo de conjunto |

### Historias no terminadas

| Historia | Avance | Razón | Acción siguiente |
|---|---|---|---|
| — | — | Las cinco historias comprometidas se completaron | Iniciar HU-01 y HU-02 en la siguiente iteración |

---

## 18. Retroalimentación del cliente

**Funcionalidades presentadas:**
Captura manual de datos, validación de entradas, selección población/muestra y presentación de resultados en consola.
<br>

**Comentarios del cliente:**
Pendiente de la sesión de revisión.
<br>

**Cambios solicitados:**
Pendiente de la sesión de revisión.
<br>

---

## 19. Métricas de la iteración

| Métrica | Resultado |
|---|---|
| Historias comprometidas | 5 |
| Historias terminadas | 5 |
| Puntos comprometidos | 15 |
| Puntos completados | 15 |
| Pruebas automatizadas | 17 |
| Pruebas exitosas | 17 |
| Defectos encontrados | 3 |
| Defectos corregidos | 3 |
| Commits realizados | _(ejecutar `git log --oneline` y contar)_ |
| Integraciones realizadas | _(igual al número de ciclos cerrados en verde)_ |

---

## 20. Retrospectiva

### ¿Qué funcionó bien?

Definir los casos de prueba antes de escribir el código obligó al equipo a precisar el comportamiento esperado en situaciones que no eran evidentes en la historia de usuario, como el conjunto vacío o la muestra de una sola observación. Separar la lógica de cálculo de la interfaz de consola permitió que las clases `ConjuntoDatos` y `CalculadoraDesviacion` fueran verificables de forma automática, sin depender de la entrada del usuario.

### ¿Qué problemas encontramos?

La mayor parte del tiempo perdido no correspondió a la lógica del problema, sino a errores de estructura: métodos duplicados dentro de una misma clase y pruebas escritas fuera de la llave de cierre, lo que impedía compilar. También hubo demora al inicio porque JUnit no estaba agregado al classpath del proyecto y las pruebas no podían ejecutarse.

### ¿Qué debemos mejorar en la siguiente iteración?

Verificar que el entorno de pruebas funcione antes de comenzar a escribir código, y hacer commits más frecuentes y pequeños en lugar de acumular varios cambios en uno solo, para que el historial refleje realmente el ciclo RED–GREEN–REFACTOR.

**Acción de mejora prioritaria:** ejecutar una prueba mínima al inicio de la iteración para confirmar que el entorno compila y corre pruebas antes de avanzar.

**Responsable:** Mendivil M.

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
La lectura de datos está acoplada a la consola dentro de `Main`. Para incorporar la carga de archivos CSV convendrá extraer una abstracción de origen de datos que permita alternar entre captura manual y archivo sin duplicar la validación.
<br>

**Nuevas necesidades identificadas:**
Manejo de archivos con encabezados y con celdas vacías; definir si una celda no numérica dentro del CSV detiene el proceso o se omite.
<br>

---

## Lista de verificación XP de la iteración

Antes de finalizar, verificar cuáles prácticas de XP fueron utilizadas:

- [x] Planning Game / planeación mediante historias
- [x] User Stories
- [ ] Small Releases
- [x] Pair Programming
- [x] Test-Driven Development
- [x] Refactoring
- [x] Simple Design
- [ ] Continuous Integration
- [x] Collective Code Ownership
- [x] Coding Standards
- [ ] Retroalimentación frecuente del cliente

---

## Reflexión final

**¿De qué manera las prácticas de XP ayudaron al equipo a responder a cambios y mantener la calidad del software durante esta iteración?**

La práctica que más aportó fue TDD. Escribir las pruebas antes del código obligó a decidir el comportamiento esperado en los casos límite antes de programarlos, y fue así como se detectó que calcular la desviación de una muestra con una sola observación divide entre cero. Ese caso no aparecía en la historia de usuario y se habría descubierto hasta la ejecución.

Cuando el equipo modificó `CalculadoraDesviacion` para extraer los métodos `varianza` y `validar`, las pruebas existentes sirvieron como red de seguridad: al volver a ejecutarlas y verlas en verde se confirmó que el diseño había cambiado sin alterar el comportamiento. Sin esa red, refactorizar habría significado revisar los resultados a mano.

El trabajo en pareja aportó revisión inmediata. Varios de los errores que se detectaron —métodos duplicados, pruebas fuera del cuerpo de la clase, el uso de comparación exacta entre valores `double` sin tolerancia— fueron señalados por el Navigator antes de que llegaran al repositorio.

Simple Design mantuvo el alcance controlado: se resolvió el problema con dos clases de lógica y una de presentación, sin introducir jerarquías ni abstracciones que la historia no exigía. Esa simplicidad fue precisamente lo que permitió incorporar la validación de la muestra mínima con una sola condición añadida.
<br>