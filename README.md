Semana 1

# Actividad Formativa: Explorando la Sobrecarga y Sobreescritura en Clases Derivadas

Este repositorio contiene la solución práctica para la actividad formativa de la Semana 1, enfocada en el desarrollo de un sistema de reparto a domicilio para la empresa **SpeedFast**. El objetivo principal es aplicar los conceptos de **polimorfismo**, **sobreescritura** y **sobrecarga** de métodos en el lenguaje de programación Java.

## Descripción del Proyecto

SpeedFast requiere un sistema automatizado para gestionar la asignación de repartidores según el tipo de pedido. El sistema maneja tres tipos de servicios específicos, cada uno con criterios de asignación diferenciados:

* **Pedido de Comida**: Requiere obligatoriamente un repartidor con mochila térmica.
* **Pedido de Encomienda**: Requiere una validación previa de peso y embalaje.
* **Pedido Compra Express**: Se asigna automáticamente al repartidor más cercano con disponibilidad inmediata.

Para resolver esta problemática de forma limpia y escalable, se implementó una jerarquía de clases que aprovecha el polimorfismo para ejecutar reglas de negocio particulares según el tipo de objeto en tiempo de ejecución.

## Arquitectura del Sistema (Jerarquía de Clases)

El diseño de software consta de una estructura jerárquica basada en la programación orientada a objetos:

* **Clase Base (`Pedido`)**: Define los atributos comunes (`idPedido`, `direccionEntrega`, `tipoPedido`) y el método genérico `asignarRepartidor()`.
* **Clases Derivadas (`PedidoComida`, `PedidoEncomienda`, `PedidoExpress`)**: Heredan de la clase base y sobrescriben el comportamiento del método de asignación.
* **Sobrecarga de Métodos**: Cada clase implementa una variante del método que acepta argumentos (`asignarRepartidor(String nombreRepartidor)`), permitiendo realizar validaciones específicas con datos de entrada.

## Estructura del Código

El proyecto está organizado en los siguientes archivos fuentes dentro del entorno Java:

* `Pedido.java`: Clase principal que actúa como molde genérico.
* `PedidoComida.java`: Subclase especializada en el reparto de restaurantes.
* `PedidoEncomienda.java`: Subclase especializada en el transporte de documentos o paquetes.
* `PedidoExpress.java`: Subclase especializada en compras de supermercado o farmacia.
* `Main.java`: Clase de pruebas que orquesta la instanciación y ejecución de los métodos de control.

## Requisitos de Ejecución

* **Java Development Kit (JDK)**: Versión 11 o superior.
* **IDE Recomendado**: IntelliJ IDEA, Eclipse o NetBeans (también ejecutable mediante terminal).

## Instrucciones de Uso

1. Clone este repositorio en su máquina local:
   ```bash
   git clone https://github.com
   ```
2. Abra el proyecto en su entorno de desarrollo preferido.
3. Compile y ejecute la clase `Main.java`.

La salida en consola demostrará el comportamiento dinámico del polimorfismo al invocar las versiones **sobrescritas** (sin parámetros) y **sobrecargadas** (con el nombre del repartidor) de cada tipo de pedido.

Semana 2

# Actividad Formativa: Implementación de Clases Abstractas y Métodos Obligatorios

Este repositorio contiene la evolución del sistema de reparto a domicilio para la empresa **SpeedFast** correspondiente a la Semana 2. El objetivo de esta fase es estructurar una solución más robusta y reutilizable mediante el uso de **clases abstractas** y **métodos abstractos**, obligando a las clases derivadas a definir su propia lógica de negocio para el cálculo de tiempos.

## Descripción de la Evolución

En esta etapa, el sistema requiere calcular de forma automatizada el **tiempo estimado de entrega** de cada pedido, considerando que la duración se ve afectada por factores específicos del tipo de servicio y la distancia en kilómetros. 

Para asegurar que todo pedido implemente obligatoriamente su regla de cálculo sin duplicar código común, se ha refactorizado la jerarquía de clases transformando la clase base en una estructura abstracta.

## Arquitectura del Sistema (Refactorización)

La nueva estructura del software define un contrato estricto de herencia:

* **Clase Abstracta (`Pedido`)**:
  * **Atributos Comunes**: `idPedido` (String), `direccionEntrega` (String) y `distanciaKm` (double).
  * **Método Implementado (`mostrarResumen()`)**: Centraliza la impresión de los datos básicos del pedido para evitar redundancia.
  * **Método Abstracto (`calcularTiempoEntrega()`)**: Define la firma obligatoria (retorna un entero con los minutos) que cada subclase debe desarrollar.

* **Clases Derivadas y Lógica de Negocio**:
  * **`PedidoComida`**: `Tiempo = 15 min base + 2 min por cada kilómetro`.
  * **`PedidoEncomienda`**: `Tiempo = 20 min base + 1.5 min por kilómetro` (el resultado se ajusta a valor entero).
  * **`PedidoExpress`**: `Tiempo = 10 min base`. Si la distancia es estrictamente mayor a 5 km, se penaliza con `5 min extra`.

## Estructura del Proyecto

* `Pedido.java`: Clase abstracta que define el molde global y el comportamiento base.
* `PedidoComida.java`: Subclase con la fórmula de tiempos para restaurantes.
* `PedidoEncomienda.java`: Subclase con la fórmula y casteo a entero para correspondencia/paquetes.
* `PedidoExpress.java`: Subclase con la lógica condicional para compras de supermercado o farmacia.
* `Main.java`: Clase conductora que instancia los objetos, ejecuta los resúmenes y presenta una comparativa clara de los tiempos calculados.

## Requisitos del Entorno

* **Java Development Kit (JDK)**: Versión 11 o superior.
* **IDE**: Cualquier entorno compatible con Java (IntelliJ IDEA, Eclipse, VS Code).

## Ejecución del Programa

1. Compile todos los archivos del proyecto:
   ```bash
   javac *.java
   ```
2. Ejecute la clase principal para observar la salida comparativa:
   ```bash
   java Main
   ```

La consola mostrará de forma organizada el resumen de cada pedido junto con su respectivo tiempo estimado, demostrando la correcta ejecución del despacho dinámico de métodos abstractos.

Semana 3

# Sistema Integral de Entregas SpeedFast (Versión Final)

Este repositorio contiene la solución definitiva para el sistema de reparto a domicilio de la empresa **SpeedFast**. En esta etapa final, se consolidan los pilares de la Programación Orientada a Objetos (**Abstracción** y **Polimorfismo**) junto con el uso de **Interfaces** para desacoplar las operaciones funcionales y garantizar una arquitectura mantenible, limpia y extensible.

## Arquitectura y Principios de Diseño

El sistema se ha diseñado bajo un esquema de bajo acoplamiento y alta cohesión, estructurado de la siguiente manera:

### 1. Abstracción
* **Clase Abstracta `Pedido`**: Actúa como la raíz de la jerarquía. Define los atributos comunes (`idPedido`, `direccionEntrega`, `distanciaKm`), el método implementado `mostrarResumen()` y el contrato obligatorio mediante el método abstracto `calcularTiempoEntrega()`.

### 2. Polimorfismo (Sobrecarga y Sobreescritura)
* **Método Sobreescrito `asignarRepartidor()`**: Cada subclase específica (`PedidoComida`, `PedidoEncomienda`, `PedidoExpress`) implementa su propia regla de negocio para la asignación automática de repartidores (mochila térmica, validación de peso o disponibilidad inmediata).
* **Método Sobregargado `asignarRepartidor(String nombreRepartidor)`**: Permite la asignación manual de un repartidor en específico, ejecutando de igual forma las validaciones contextuales del tipo de pedido.

### 3. Interfaces (Desacoplamiento Operacional)
Para separar las responsabilidades comunes del flujo de los pedidos, se han definido tres interfaces clave implementadas a nivel de lógica de negocio:
* **`Despachable`**: Declara el método `despachar()`, encargado de iniciar la ruta física del envío.
* **`Cancelable`**: Declara el método `cancelar()`, que gestiona la anulación segura del pedido.
* **`Rastreable`**: Declara el método `verHistorial()`, diseñado para auditar el flujo y estados de las entregas.

## Estructura del Código Fuente

El proyecto se compone de los siguientes módulos interconectados en Java:

* `Pedido.java`: Clase abstracta base.
* `PedidoComida.java`: Subclase con lógica para restaurantes y transporte térmico.
* `PedidoEncomienda.java`: Subclase con lógica para paquetería y control de peso/embalaje.
* `PedidoExpress.java`: Subclase con lógica para supermercados/farmacias con prioridad de cercanía.
* `Despachable.java`, `Cancelable.java`, `Rastreable.java`: Interfaces funcionales del sistema.
* `ControladorDeEnvios.java`: Componente encargado de orquestar los estados, operaciones de las interfaces y el almacenamiento del histórico.
* `Main.java`: Orquestador principal que ejecuta la simulación completa del ciclo de vida de los pedidos.

## Simulación del Ciclo de Vida (Clase Main)

La ejecución del programa demuestra el funcionamiento del sistema a través de un escenario real que incluye:
1. **Instanciación** de múltiples tipos de pedidos con parámetros de distancia específicos.
2. **Asignación de Repartidores** evaluando flujos automáticos y asignaciones manuales nominales.
3. **Cálculo Dinámico** de los tiempos estimados de entrega en base a las reglas de negocio particulares.
4. **Operaciones del Flujo**: Despacho de órdenes activas y simulación de una cancelación.
5. **Auditoría**: Despliegue del historial completo de transacciones realizadas utilizando estructuras de datos dinámicas (`ArrayList`).

## Requisitos de Ejecución

* **Java Development Kit (JDK)**: Versión 11 o superior.
* **Consola de comandos** o cualquier IDE compatible (IntelliJ IDEA, Eclipse, NetBeans).

## Compilación y Ejecución

Para verificar el correcto funcionamiento de la simulación integral, ejecute los siguientes comandos en su terminal:

```bash
# Compilar todos los componentes del sistema
javac *.java

# Lanzar la simulación principal
java Main
```
Semana 4

# Sistema Integral de Entregas SpeedFast - Módulo de Simulación Concurrente

Este repositorio contiene la evolución del sistema de reparto a domicilio para la empresa **SpeedFast** correspondiente a la **Semana 4**. El objetivo central de esta fase es incorporar **programación concurrente** en Java para simular el comportamiento en tiempo real de múltiples repartidores operando de manera simultánea e independiente a través de hilos de ejecución.

## 📋 Descripción del Caso

A partir de la arquitectura orientada a objetos previamente consolidada (basada en abstracción, polimorfismo e interfaces), el sistema ahora requiere modelar un entorno operativo real. Cada repartidor de la empresa funciona como una entidad autónoma que procesa su propia hoja de ruta (lista de pedidos asignados) en paralelo con sus compañeros. 

El sistema utiliza retardos controlados y aleatorios para representar los tiempos físicos de traslado, notificando de manera dinámica el progreso y estado de cada entrega en la consola central.

---

## 🏗️ Arquitectura y Diseño del Software

El diseño combina las bases de la Programación Orientada a Objetos (POO) con el API de Concurrencia de Java:

### 1. Estructura Orientada a Objetos (Legado)
* **Clase Abstracta `Pedido`**: Define la raíz común del dominio con atributos clave (`idPedido`, `direccionEntrega`, `distanciaKm`) y métodos para el negocio (`calcularTiempoEntrega()`, `mostrarResumen()`).
* **Especializaciones de Servicio**: Las subclases `PedidoComida`, `PedidoEncomienda` y `PedidoExpress` mantienen sus reglas de negocio particulares y fórmulas para el cálculo de tiempos estimados de entrega.
* **Interfaces de Control**: Se reutilizan `Despachable`, `Cancelable` y `Rastreable` para desacoplar las operaciones logísticas del ciclo de vida de los envíos.

### 2. Módulo Concurrente (Nueva Implementación)
* **Clase `Repartidor` (Procesamiento Asíncrono)**: 
  * Implementa la interfaz nativa `Runnable`.
  * Encapsula los atributos `nombre` y una colección dinámica (`List<Pedido>`) de órdenes asignadas.
  * Su método sobrescrito `run()` gobierna el despacho secuencial de su lista, utilizando `Thread.sleep()` con intervalos aleatorios para simular el desplazamiento físico hacia el destino.
* **Orquestación en `Main` (`ExecutorService`)**: 
  * Se despliega un pool de hilos administrado para iniciar en paralelo las tareas de los repartidores de forma eficiente.
  * Implementa un bloqueo controlado de sincronización mediante `awaitTermination` para asegurar que el programa principal informe el cierre solo cuando todos los hilos completen sus rutas de manera exitosa.

---

## 📂 Estructura del Proyecto

El código fuente dentro de la carpeta `src/main/java` queda organizado de la siguiente manera:

*   `Pedido.java`: Clase abstracta molde del sistema.
*   `PedidoComida.java`: Subclase con lógica para entregas de restaurantes.
*   `PedidoEncomienda.java`: Subclase para control y transporte de paquetería.
*   `PedidoExpress.java`: Subclase especializada en compras rápidas de conveniencia.
*   `Despachable.java` / `Cancelable.java` / `Rastreable.java`: Interfaces funcionales operativas.
*   `Repartidor.java`: Unidad de trabajo concurrente (`Runnable`) encargada de realizar las entregas.
*   `Main.java`: Clase conductora que instancia los datos de prueba, arranca el `ExecutorService` y gestiona el ciclo de vida de la simulación.

---

## 🛠️ Requisitos de Ejecución

*   **Java Development Kit (JDK)**: Versión 11 o superior (Recomendado JDK 17 o 21).
*   **IDE**: IntelliJ IDEA (Community o Ultimate Edition).

---

## 🚀 Instrucciones de Ejecución

### Desde IntelliJ IDEA
1. Abra IntelliJ IDEA y seleccione **Open** o **Import Project**.
2. Navegue hasta la carpeta raíz del proyecto y selecciónela.
3. Asegúrese de que el proyecto esté configurado con el SDK correcto (`File` > `Project Structure` > `Project`).
4. Busque el archivo `Main.java`, haga clic derecho sobre él y seleccione **Run 'Main.main()'**.

### Desde la Terminal (Consola de Comandos)
1. Compile todos los componentes del sistema:
   ```bash
   javac src/main/java/*.java -d out/
   ```
2. Lance la simulación principal:
   ```bash
   java -cp out/ Main
   ```

---

