# 🎮 Pokemon Battle Game - Trabajo Práctico Algoritmos 3

Un simulador de batallas de Pokemon por turnos desarrollado en Java, que demuestra la implementación de principios SOLID y patrones de diseño avanzados en un sistema de combate completo.

## 📋 Descripción

Este proyecto es un juego de batallas Pokemon implementado como trabajo práctico para Algoritmos y Programación 3. El sistema permite batallas por turnos entre dos entrenadores, cada uno con un equipo de hasta 6 Pokemon. El juego incluye un sistema completo de tipos, habilidades, estados, objetos y cálculo de daño con efectividad de tipos.

### 🎯 Características Principales

- **Sistema de Combate por Turnos**: Batallas estratégicas entre dos entrenadores
- **Sistema de Tipos**: 15 tipos de Pokemon con tabla de efectividades (Fuego, Agua, Eléctrico, Planta, Hielo, Dragón, Siniestro, Psíquico, Lucha, Roca, Tierra, Volador, Bicho, Fantasma, Veneno, Normal)
- **71 Habilidades**: Divididas en ataques, modificadores de estadísticas y efectos de estado
- **6 Estados de Pokemon**: Normal, Paralizado, Dormido, Envenenado, Confundido, Debilitado
- **14 Objetos**: Pociones, curas de estado, revivir, potenciadores de estadísticas
- **Cálculo de Daño Complejo**: Incluye nivel, críticos, efectividad de tipo, STAB, y variación aleatoria
- **Gestión de Equipos**: Cada entrenador maneja un equipo de 6 Pokemon

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Java 17
- **Gestor de Construcción**: Maven
- **IDE Recomendado**: IntelliJ IDEA / Eclipse / NetBeans
- **Paradigma**: Programación Orientada a Objetos

## 🏗️ Patrones de Diseño Implementados

Este proyecto demuestra la implementación práctica de múltiples patrones de diseño:

### Patrones Creacionales
- **Builder** (`PokemonBuilder`): Construcción fluida de Pokemon con configuraciones personalizadas
- **Factory** (`HabilidadesFactory`, `EstadisticaFactory`, `JugadaFactory`): Creación de habilidades, estadísticas y jugadas

### Patrones Estructurales
- **Type Object** (jerarquía `Elemento`): Sistema de tipos con 15 elementos diferentes

### Patrones de Comportamiento
- **Strategy** (jerarquías `Estado` y `Habilidad`): Diferentes estrategias de ataque y manejo de estados
- **State** (paquete `estado/`): Estados del Pokemon que afectan su comportamiento en batalla
- **Command** (paquete `comando/`): Encapsulación de acciones de batalla como objetos
- **Chain of Responsibility** (`Comando.concatComands()`): Encadenamiento de comandos
- **Singleton** (`Eventos`, `Log`): Sistema de eventos y logging con instancia única
- **Template Method** (`Estadisticas`): Esqueleto para cálculos de estadísticas

### Principios SOLID
- **Single Responsibility**: Cada clase tiene una responsabilidad específica
- **Open/Closed**: Extensible mediante herencia sin modificar clases base
- **Liskov Substitution**: Las subclases pueden sustituir a sus clases base
- **Interface Segregation**: Interfaces específicas en lugar de una interfaz general
- **Dependency Inversion**: Dependencia de abstracciones, no de implementaciones concretas

## 📁 Estructura del Proyecto

```
PokemonAlgo3/
├── src/main/java/org/example/
│   ├── pokemon/              # Entidad Pokemon y Builder
│   ├── habilidad/            # Sistema de habilidades (Ataque, Modificadores, Estados)
│   ├── estado/               # Estados del Pokemon (Normal, Paralizado, Dormido, etc.)
│   ├── Elemento/             # Sistema de tipos (15 tipos elementales)
│   ├── Estadistica/          # Modificadores de estadísticas
│   ├── Estadisticas/         # Gestión y cálculo de estadísticas
│   ├── items/                # Sistema de objetos (Pociones, Curas, Revivir)
│   ├── comando/              # Implementación del patrón Command
│   ├── Turno/                # Sistema de turnos y eventos
│   ├── jugada/               # Mecánicas de juego (Atacar, Usar objeto, Cambiar, Rendirse)
│   ├── pokebola/             # Gestión de equipo de Pokemon
│   ├── Log/                  # Sistema de logging
│   ├── Main.java             # Punto de entrada
│   ├── Juego.java            # Gestor de batalla
│   ├── Entrenador.java       # Entidad entrenador
│   └── CalculadoraDanio.java # Motor de cálculo de daño
└── pom.xml                   # Configuración Maven
```

**Estadísticas del Código:**
- 85 archivos Java
- ~3,400 líneas de código
- 13 paquetes organizados por responsabilidad

## 🚀 Cómo Ejecutar el Juego

### Prerequisitos
- Java JDK 17 o superior
- Maven (opcional, si deseas construir desde línea de comandos)
- IDE con soporte para Maven (IntelliJ IDEA, Eclipse, NetBeans)

### Pasos de Instalación

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/Kevin00404/Tp_algoritmos3.git
   cd Tp_algoritmos3
   ```

2. **Importar el proyecto al IDE**:
   - Abre tu IDE preferido
   - Importa la carpeta `PokemonAlgo3` como un proyecto Maven
   - Espera a que Maven descargue las dependencias (si las hubiera)

3. **Ejecutar el juego**:
   - Navega a la clase `Main.java` en `src/main/java/org/example/`
   - Ejecuta la clase Main
   - Sigue las instrucciones en consola para jugar

### Ejecución desde Línea de Comandos

```bash
cd PokemonAlgo3
mvn clean compile
mvn exec:java -Dexec.mainClass="org.example.Main"
```

## 📊 Diagrama de Clases

El diagrama de clases completo del proyecto está disponible en Lucidchart:

🔗 [Ver Diagrama de Clases](https://lucid.app/lucidchart/11c2d205-9b2d-46e0-9a54-f8facff64de4/edit?viewport_loc=-3108%2C-1309%2C8000%2C3556%2C0_0&invitationId=inv_a28dd9fe-0638-464f-ba4a-3c049debfc31)

*Nota: Se requiere una cuenta en lucid.app para acceder al diagrama*

## 🎓 Propósito Académico

Este proyecto fue desarrollado como trabajo práctico para la materia Algoritmos y Programación 3, con el objetivo de:
- Aplicar principios de diseño orientado a objetos
- Implementar patrones de diseño de manera práctica
- Desarrollar un sistema complejo y bien estructurado
- Demostrar buenas prácticas de programación en Java

## 📝 Licencia

Este proyecto está bajo la licencia especificada en el archivo [LICENSE](LICENSE).

## 👥 Contribuciones

Este es un proyecto académico. Para consultas o sugerencias, por favor contacta al autor del repositorio.
