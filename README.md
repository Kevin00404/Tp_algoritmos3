# Batalla de Pokemones - Trabajo Práctico Algoritmos 3

Un simulador de batallas de Pokemon por turnos desarrollado en Java basado en el juego Pokemon Rojo Fuego, que demuestra la implementación de principios SOLID y patrones de diseño avanzados en un sistema de combate completo.

<img width="400" height="392" alt="image" src="https://github.com/user-attachments/assets/b075f134-cc97-4c4a-a8f4-8eb4aed31f63" />


## Descripción

Este proyecto es un juego de batallas Pokemon implementado como trabajo práctico para Algoritmos y Programación 3. El sistema permite batallas por turnos entre dos entrenadores, cada uno con un equipo de hasta 6 Pokemon. El juego incluye un sistema completo de tipos, habilidades, estados, objetos y cálculo de daño con efectividad de tipos.

### Características Principales

- **Sistema de Combate por Turnos**: Batallas estratégicas entre dos entrenadores
- **Sistema de Tipos**: 15 tipos de Pokemon con tabla de efectividades (Fuego, Agua, Eléctrico, Planta, Hielo, Dragón, Siniestro, Psíquico, Lucha, Roca, Tierra, Volador, Bicho, Fantasma, Veneno, Normal)
- **71 Habilidades**: Divididas en ataques, modificadores de estadísticas y efectos de estado
- **6 Estados de Pokemon**: Normal, Paralizado, Dormido, Envenenado, Confundido, Debilitado
- **14 Objetos**: Pociones, curas de estado, revivir, potenciadores de estadísticas
- **Cálculo de Daño Complejo**: Incluye nivel, críticos, efectividad de tipo, STAB, y variación aleatoria
- **Gestión de Equipos**: Cada entrenador maneja un equipo de 6 Pokemon

## Tecnologías Utilizadas

- **Lenguaje**: Java 17
- **Gestor de Construcción**: Maven
- **IDE Recomendado**: IntelliJ IDEA / Eclipse / NetBeans
- **Paradigma**: Programación Orientada a Objetos

## Cómo Ejecutar el Juego

### Prerrequisitos
- Java JDK 17 o superior
- Maven (opcional, si deseas construir desde línea de comandos)
- IDE con soporte para Maven (IntelliJ IDEA, Eclipse, NetBeans)

### Pasos de Instalación

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/Kevin00404/batalla_pokemon.git
   cd batalla_pokemon
   ```

2. **Importar el proyecto al IDE**:
   - Abre tu IDE preferido
   - Importa la carpeta `PokemonAlgo3` como un proyecto Maven
   - Espera a que Maven descargue las dependencias (si las hubiera)

3. **Ejecutar el juego**:
   - Navega a la clase `Main.java` en `src/main/java/org/example/`
   - Ejecuta la clase Main
   - Sigue las instrucciones en consola para jugar

## Propósito Académico

Este proyecto fue desarrollado como trabajo práctico para la materia Algoritmos y Programación 3, con el objetivo de:
- Aplicar principios de diseño orientado a objetos
- Implementar patrones de diseño de manera práctica
- Desarrollar un sistema complejo y bien estructurado
- Demostrar buenas prácticas de programación en Java
