package org.example;
import java.util.Scanner;
import org.example.Elemento.*;
import org.example.Estadistica.ModificacionEstadistica;
import org.example.Estadistica.modAtaque;
import org.example.Estadistica.ModDefensa;
import org.example.Estadistica.ModVelocidad;
import org.example.estado.EstadoDormido;
import org.example.estado.EstadoEnvenenado;
import org.example.estado.EstadoParalizado;
import org.example.habilidad.HabilidadAtaque;
import org.example.habilidad.HabilidadModificacionEstadistica;
import org.example.habilidad.HabilidadModificacionEstado;
import org.example.items.*;
import org.example.pokemon.Pokemon;

public class Juego {
    Entrenador entrenador1;
    Entrenador entrenador2;
    final Integer POKEMONES_POR_POKEBOLA = 6;
    public  EstadoPokemon estadoMiPokemon;

    public ModificacionEstadistica modificacionEstadisticaPokemon;
    private Scanner scanner;
    public Juego(){
        scanner = new Scanner(System.in);
        this.inicializar();
        this.batalla();
    }

    public void batalla() {
        System.out.println("¡Comienza la batalla de Pokémon!");
        while (entrenador1.tienePokemonDisponible() && entrenador2.tienePokemonDisponible()) {
            if(!entrenador1.pokemonEstaVivo()){
                entrenador1.setPokemonActual(entrenador1.pokebola.cambiarPokemon());
            }
            // Turno de entrenador1
            turnoJugador(entrenador1, entrenador2);
            //verificar si se rindio
            if (!entrenador1.tienePokemonDisponible()){
                break;
            }
            // Verificar si entrenador2 sigue vivo
            if (!entrenador2.tienePokemonDisponible()) {
                System.out.println("entrenador 2 ha perdido.");
                break;
            }
            if(!entrenador2.pokemonEstaVivo()){
                entrenador2.setPokemonActual(entrenador2.pokebola.cambiarPokemon());
            }
            // Turno de entrenador2
            turnoJugador(entrenador2, entrenador1);
            //verificar si se rindio
            if (!entrenador2.tienePokemonDisponible()){
                break;
            }
            // Verificar si entrenador1 sigue vivo
            if (!entrenador1.tienePokemonDisponible()) {
                System.out.println("entrenador 1 ha perdido.");
                break;
            }
        }

        System.out.println("¡Fin del juego!");
    }
    private void compararVelocidades() {
        if (entrenador1.pokemonActual.getVelocidad() > entrenador2.pokemonActual.getVelocidad()){

        } else {

        }
    }

    public void turnoJugador(Entrenador jugador, Entrenador oponente) {
        boolean turno = false;
        while(!turno){
            System.out.println("Entrenador " + jugador.getNroEntrenador() + ", es tu turno.");
            System.out.println("Elige una opción:");
            System.out.println("1. Atacar");
            System.out.println("2. Usar Item");
            System.out.println("3. Mostrar campo de batalla");
            System.out.println("4. Cambiar Pokemon");
            System.out.println("5. Rendirse");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    mostrarHabilidades(jugador.getPokemon()); /* ACÁ SE DEBERÍA BUSCAR EN JUGADOR.POKEBOLA.GETACTIVO() O ALGO ASÍ Y LUEGO LAS HABILIDADES DE ESE POKEMON*/
                    int habilidadElegida = scanner.nextInt();
                    if (habilidadElegida == 5){
                        break;
                    }
                    //Habilidad habilidad = jugador.getPokemon()/* ACÁ TAMBIÉN */.habilidades.get(habilidadElegida);
                    turno = jugador.atacar(oponente/* ACÁ TAMBIÉN */, habilidadElegida /* ACÁ VAN LOS PARÁMETROS DEL MÉTODO DE LA CLASE ESTADO */);
                    break;
                case 2:
                    /* ACÁ TIENE QUE IR A BUSCAR AL POKEMON ACTIVO Y APLICARLE EL ITEM SELECCIONADO */
                    System.out.println("seleccione item: ");
                    jugador.verMochila();
                    int objetoElegido = scanner.nextInt();
                    if (objetoElegido == 0){
                        break;
                    }
                    System.out.println("se ha Elegido: "+ objetoElegido);
                    System.out.println("seleccione pokemon: ");
                    jugador.verEquipo();
                    String pokemonElegido = scanner.next();
                    turno = jugador.usarItemEnMochila(objetoElegido , jugador.pokebola.obtenerPokemon(pokemonElegido) );
                    jugador.aplicarEfectos();
                    break;
                case 3:
                    campoDeBatalla(jugador, oponente);
                    break;
                case 4:
                    jugador.aplicarEfectos();
                    System.out.println("x: cancelar");
                    Pokemon opcionElegida = jugador.pokebola.cambiarPokemon();
                    if (opcionElegida == null){
                        break;
                    }
                    jugador.setPokemonActual(opcionElegida);
                    turno = true;
                    break;
                case 5:
                    jugador.rendirse();
                    System.out.println("jugador " + jugador.getNroEntrenador() + " se ha rendido. " + "jugador " + oponente.getNroEntrenador() + " gana la batalla.");
                    turno = true;
                    break;
                default:
                    System.out.println("Opción no válida. Se considera un turno sin acción.");
                    break;
            }
        }
    }
    private void mostrarHabilidades(Pokemon pokemon) {
        pokemon.mostrarHabilidades();
    }
    public void campoDeBatalla(Entrenador jugador, Entrenador oponente){
        System.out.println("Detalles del campo de Batalla:");
        System.out.println("tu pokemon:");
        jugador.mostrarPokemonEnBatalla();
        System.out.println("pokemon enemigo");
        oponente.mostrarPokemonEnBatalla();
    }
    private void inicializar(){

        /* ATAQUE (DAÑO)*/

        /*FUEGO*/
        HabilidadAtaque ascuas = new HabilidadAtaque("ascuas", 25, new Fuego(), 40.0);
        HabilidadAtaque lanzallamas = new HabilidadAtaque("lanzallamas", 25, new Fuego(), 90.0);

        /* AGUA */
        HabilidadAtaque hidroCanion = new HabilidadAtaque("hidroCanion", 25, new Agua(), 150.0);
        HabilidadAtaque rayoBurbuja = new HabilidadAtaque("rayoBurbuja", 25, new Agua(), 65.0);

        /* BICHO */
        HabilidadAtaque corteFuria = new HabilidadAtaque("corteFuria", 25, new Bicho(), 40.0);
        HabilidadAtaque picadura = new HabilidadAtaque("picadura", 25, new Bicho(), 60.0);

        /* DRAGÓN */
        HabilidadAtaque cargaDragon = new HabilidadAtaque("cargaDragon", 25, new Dragon(), 100.0);
        HabilidadAtaque pulsoDragon = new HabilidadAtaque("pulsoDragon", 25, new Dragon(), 80.0);

        /* ELÉCTRICO */
        HabilidadAtaque impactrueno = new HabilidadAtaque("impactrueno", 25, new Electrico(), 40.0);
        HabilidadAtaque electrocanion = new HabilidadAtaque("electrocanion", 1, new Electrico(), 1200000000000000000000000000.0);

        /* FANTASMA */
        HabilidadAtaque bolaSombra = new HabilidadAtaque("bolaSombra", 25, new Fantasma(), 80.0);
        HabilidadAtaque poltergeist = new HabilidadAtaque("poltergeist", 25, new Fantasma(), 110.0);

        /* HIELO */
        HabilidadAtaque rayoHielo = new HabilidadAtaque("rayoHielo", 25, new Hielo(), 90.0);
        HabilidadAtaque ventisca = new HabilidadAtaque("ventisca", 25, new Hielo(), 110.0);

        /* LUCHA */
        HabilidadAtaque demolicion = new HabilidadAtaque("demolicion", 25, new Lucha(), 75.0);
        HabilidadAtaque doblePatada = new HabilidadAtaque("doblePatada", 25, new Lucha(), 60.0);

        /* NORMAL */
        HabilidadAtaque placaje = new HabilidadAtaque("placaje", 25, new Normal(), 40.0);
        HabilidadAtaque corte = new HabilidadAtaque("corte", 25, new Normal(), 50.0);

        /* PLANTA */
        HabilidadAtaque latigoCepa = new HabilidadAtaque("latigoCepa", 25, new Planta(), 45.0);
        HabilidadAtaque clorofilaser = new HabilidadAtaque("clorofilaser", 25, new Planta(), 120.0);

        /* PSÍQUICO */
        HabilidadAtaque comeSuenios = new HabilidadAtaque("comeSuenios", 25, new Psiquico(), 100.0);
        HabilidadAtaque psicoRayo = new HabilidadAtaque("psicoRayo", 25, new Psiquico(), 65.0);

        /* ROCA */
        HabilidadAtaque avalancha = new HabilidadAtaque("avalancha", 25, new Roca(), 75.0);
        HabilidadAtaque lanzaRocas = new HabilidadAtaque("lanzaRocas", 25, new Roca(), 50.0);

        /* TIERRA */
        HabilidadAtaque disparoLodo = new HabilidadAtaque("disparoLodo", 25, new Tierra(), 55.0);
        HabilidadAtaque terremoto = new HabilidadAtaque("terremoto", 25, new Tierra(), 100.0);

        /* VENENO */
        HabilidadAtaque acido = new HabilidadAtaque("acido", 25, new Veneno(), 40.0);
        HabilidadAtaque residuos = new HabilidadAtaque("residuos", 25, new Veneno(), 65.0);

        /* VOLADOR */
        HabilidadAtaque picoteo = new HabilidadAtaque("picoteo", 25, new Volador(), 60.0);
        HabilidadAtaque tornado = new HabilidadAtaque("tornado", 25, new Volador(), 40.0);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /* MODIFICACIÓN DE ESTADÍSTICAS (DEFENSA) */

        HabilidadModificacionEstadistica domador = new HabilidadModificacionEstadistica("domador" , 25, new ModDefensa(20.0)); /* NORMAL */
        HabilidadModificacionEstadistica descarga = new HabilidadModificacionEstadistica("descarga" , 25, new ModDefensa(20.0)); /* ELÉCTRICO */
        HabilidadModificacionEstadistica ignicion = new HabilidadModificacionEstadistica("ignicion" , 25, new ModDefensa(20.0)); /* FUEGO */
        HabilidadModificacionEstadistica mantoFrondoso = new HabilidadModificacionEstadistica("mantoFrondoso" , 25, new ModDefensa(20.0)); /* PLANTA */
        HabilidadModificacionEstadistica escamaEspecial = new HabilidadModificacionEstadistica("escamaEspecial" , 25, new ModDefensa(20.0)); /* DRAGON */
        HabilidadModificacionEstadistica rociador = new HabilidadModificacionEstadistica("rociador" , 25, new ModDefensa(20.0)); /* AGUA */
        HabilidadModificacionEstadistica defensaLodo = new HabilidadModificacionEstadistica("defensaLodo" , 25, new ModDefensa(20.0)); /* TIERRA */

        HabilidadModificacionEstadistica domado = new HabilidadModificacionEstadistica("domado",25, new ModDefensa(-20.0)); /* NORMAL */
        HabilidadModificacionEstadistica voltaje = new HabilidadModificacionEstadistica("voltaje",25, new ModDefensa(-20.0)); /* ELÉCTRICO */
        HabilidadModificacionEstadistica mareoIgneo = new HabilidadModificacionEstadistica("mareoIgneo",25, new ModDefensa(-20.0)); /* FUEGO */
        HabilidadModificacionEstadistica enredadera = new HabilidadModificacionEstadistica("enredadera",25, new ModDefensa(-20.0)); /* PLANTA */
        HabilidadModificacionEstadistica mareoEscamoso = new HabilidadModificacionEstadistica("mareoEscamoso",25, new ModDefensa(-20.0)); /* DRAGON */
        HabilidadModificacionEstadistica chapotear = new HabilidadModificacionEstadistica("chapotear",25, new ModDefensa(-20.0)); /* AGUA */
        HabilidadModificacionEstadistica lanzaLodo = new HabilidadModificacionEstadistica("lanzaLodo",25, new ModDefensa(-20.0)); /* TIERRA */

        /* MODIFICACIÓN DE ESTADÍSTICAS (ATAQUE) */
        HabilidadModificacionEstadistica ojoCompuesto = new HabilidadModificacionEstadistica("ojoCompuesto", 25, new modAtaque(20.0)); /* NORMAL */
        HabilidadModificacionEstadistica torrente = new HabilidadModificacionEstadistica("torrente", 25, new modAtaque(20.0)); /* AGUA */
        HabilidadModificacionEstadistica paraRayos = new HabilidadModificacionEstadistica("paraRayos", 25, new modAtaque(20.0)); /* ELÉCTRICO */

        HabilidadModificacionEstadistica intimidacion = new HabilidadModificacionEstadistica("intimidacion", 25, new modAtaque(-5.0)); /* NORMAL */
        HabilidadModificacionEstadistica sumergido = new HabilidadModificacionEstadistica("sumergido", 25, new modAtaque(-5.0)); /* AGUA */
        HabilidadModificacionEstadistica enterrado = new HabilidadModificacionEstadistica("enterrado", 25, new modAtaque(-5.0)); /* TIERRA */

        /* MODIFICACIÓN DE ESTADÍSTICAS (VELOCIDAD) */
        HabilidadModificacionEstadistica impulso = new HabilidadModificacionEstadistica("impulso", 25, new ModVelocidad(20.0)); /* NORMAL */
        HabilidadModificacionEstadistica nadoRapido = new HabilidadModificacionEstadistica("nadoRapido", 25, new ModVelocidad(20.0)); /* AGUA */
        HabilidadModificacionEstadistica clorofila = new HabilidadModificacionEstadistica("clorofila", 25, new ModVelocidad(20.0)); /* PLANTA */

        HabilidadModificacionEstadistica coabrdia = new HabilidadModificacionEstadistica("coabrdia", 25, new ModVelocidad(-20.0)); /* NORMAL */
        HabilidadModificacionEstadistica colaSurf = new HabilidadModificacionEstadistica("colaSurf", 25, new ModVelocidad(-20.0)); /* AGUA */
        HabilidadModificacionEstadistica impetuArena = new HabilidadModificacionEstadistica("impetuArena", 25, new ModVelocidad(-20.0)); /* TIERRA */

        HabilidadModificacionEstado chispa = new HabilidadModificacionEstado("chispa", 25, new EstadoParalizado()); // eléctrico
        HabilidadModificacionEstado dragonAliento = new HabilidadModificacionEstado("dragonAliento", 25, new EstadoParalizado());// dragón
        HabilidadModificacionEstado salpikaSurf = new HabilidadModificacionEstado("salpikaSurf", 25, new EstadoParalizado());// agua
        HabilidadModificacionEstado paralizador = new HabilidadModificacionEstado("paralizador", 25, new EstadoParalizado());// planta
        HabilidadModificacionEstado palmeo = new HabilidadModificacionEstado("palmeo", 25, new EstadoParalizado());// lucha

        HabilidadModificacionEstado bostezo = new HabilidadModificacionEstado("bostezo", 25, new EstadoDormido());// normal
        HabilidadModificacionEstado espora = new HabilidadModificacionEstado("espora", 25, new EstadoDormido());// planta
        HabilidadModificacionEstado gigasopor = new HabilidadModificacionEstado("gigasopor", 25, new EstadoDormido());// fantasma
        HabilidadModificacionEstado hipnosis = new HabilidadModificacionEstado("hipnosis", 25, new EstadoDormido());// psíquico
        HabilidadModificacionEstado besoAmoroso = new HabilidadModificacionEstado("besoAmoroso", 25, new EstadoDormido());// normal

        HabilidadModificacionEstado bombaLodo = new HabilidadModificacionEstado("bombaLodo", 25, new EstadoEnvenenado());// veneno
        HabilidadModificacionEstado gasVenenoso = new HabilidadModificacionEstado("gasVenenoso", 25, new EstadoEnvenenado());// veneno
        HabilidadModificacionEstado gigaDescarga = new HabilidadModificacionEstado("gigaDescarga", 25, new EstadoEnvenenado());// eléctrico
        HabilidadModificacionEstado gigaEstupor = new HabilidadModificacionEstado("gigaEstupor", 25, new EstadoEnvenenado());// planta
        HabilidadModificacionEstado picotazoVeneno = new HabilidadModificacionEstado("picotazoVeneno", 25, new EstadoEnvenenado());// veneno

//cambiar las habilidades de forma correcta

        /* SETEO POKEMONES PARA ENTRENADOR 1 */
        Pokemon charmander = new Pokemon("Charmander", new Fuego(), "Nacio en un volcan(?", picotazoVeneno, lanzallamas, placaje, ignicion);
        Pokemon squirtle = new Pokemon("Squirtle", new Agua(), "Nacio en un Lago(?", picotazoVeneno, rayoBurbuja, torrente, nadoRapido);
        Pokemon pikachu = new Pokemon ("Pikachu", new Electrico(),"Hijo de los rayos", chispa, picotazoVeneno, electrocanion, voltaje);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", new Planta(), "Nacio en un bosque(?", picotazoVeneno, clorofilaser, clorofila, enredadera);
        Pokemon flygon = new Pokemon("Flygon", new Dragon(), "Nacio en el cielo(?", picotazoVeneno, pulsoDragon, escamaEspecial, mareoEscamoso);
        Pokemon swellow = new Pokemon ("Swellow", new Volador(),"Pollito de fuego", picotazoVeneno, tornado, impulso, ojoCompuesto);

        Mochila mochilaEntrenador1 = inicializarItems();
        //rompe encapsulamiento
        Pokebola pokebola1 = new Pokebola(POKEMONES_POR_POKEBOLA);
        this.entrenador1 = new Entrenador(pokebola1 , mochilaEntrenador1 , preguntarNombre(1));
        this.entrenador1.pokebola.agregarPokemon(charmander);
        this.entrenador1.pokebola.agregarPokemon(squirtle);
        this.entrenador1.pokebola.agregarPokemon(pikachu);
        this.entrenador1.pokebola.agregarPokemon(bulbasaur);
        this.entrenador1.pokebola.agregarPokemon(flygon);
        this.entrenador1.pokebola.agregarPokemon(swellow);
        System.out.println(entrenador1.getNombre() + " elegi tu pokemon incial: ");
        Pokemon opcionElegida = entrenador1.pokebola.cambiarPokemon();
        entrenador1.setPokemonActual(opcionElegida);


        /* SETEO POKEMONES PARA ENTRENADOR 2 */
        Pokemon hariyama = new Pokemon("Hariyama", new Lucha(), "Le gusta pelear(?", ascuas, lanzallamas, placaje, ignicion);
        Pokemon swampert = new Pokemon("Swampert", new Agua(), "Nacio en un Lago(?", hidroCanion, rayoBurbuja, torrente, nadoRapido);
        Pokemon claydol = new Pokemon ("Claydol", new Electrico(),"Hijo de los rayos", impactrueno, electrocanion, descarga, voltaje);
        Pokemon exploud = new Pokemon("Exploud", new Normal(), "Nacio en un bosque(?", latigoCepa, clorofilaser, clorofila, enredadera);
        Pokemon ludicolo = new Pokemon("Ludicolo", new Planta(), "Nacio en el bosque(?", cargaDragon, pulsoDragon, escamaEspecial, mareoEscamoso);
        Pokemon cacnea = new Pokemon ("Cacnea", new Volador(),"Nacio en el bosque", picoteo, tornado, impulso, ojoCompuesto);

        Mochila mochilaEntrenador2 = inicializarItems();

        Pokebola pokebola2 = new Pokebola(POKEMONES_POR_POKEBOLA);
        this.entrenador2 = new Entrenador(pokebola2 , mochilaEntrenador2 , preguntarNombre(2));
        this.entrenador2.pokebola.agregarPokemon(hariyama);
        this.entrenador2.pokebola.agregarPokemon(swampert);
        this.entrenador2.pokebola.agregarPokemon(claydol);
        this.entrenador2.pokebola.agregarPokemon(exploud);
        this.entrenador2.pokebola.agregarPokemon(ludicolo);
        this.entrenador2.pokebola.agregarPokemon(cacnea);
        System.out.println(entrenador2.getNombre() + " elegi tu pokemon incial: ");
        Pokemon opcionElegida2 = entrenador2.pokebola.cambiarPokemon();
        entrenador2.setPokemonActual(opcionElegida2);


    }

    private String preguntarNombre(Integer numero) {
        String nombre = " ";
        System.out.println("jugador "+ numero + " ingresa tu nombre: ");
        nombre = scanner.next();
        while (nombre.length() > 50){
            System.out.println("nombre muy largo");
            System.out.println("jugador "+ numero + " ingresa tu nombre: ");
            nombre = scanner.next();
        }
        return nombre;
    }

    /* INICIALIZACION DE ITEMS */
    public Mochila inicializarItems(){
        CuraTotal curaTotal = new CuraTotal("cura total" , 1);
        PocionDespertarDormido despertar = new PocionDespertarDormido("despertar" , 1);
        PocionAntiVeneno antiVeneno = new PocionAntiVeneno("antiveneno" , 1);
        PocionCurarParalisis curarParalisis = new PocionCurarParalisis("antiparalisis" , 1);
        Pocion pocionBasica = new Pocion(20.0 ,"pocion basica" , 1);
        Pocion megaPocion = new Pocion(50.0 , "mega pocion" , 1);
        Pocion hiperPocion = new Pocion(100.0 , "hiper pocion" , 1);
        Revivir revivir = new Revivir(20.0 , "revivir" , 1);
        Revivir maxRevivir = new Revivir(100.0 , "max revivir" , 1);
        PocionDeAtaque ataqueX = new PocionDeAtaque("ataque x", 10.0 , 1);
        PocionDeDefensa defensaX = new PocionDeDefensa("defensa x" , 10.0 , 1);
        Mochila mochilaEntrenador = new Mochila();
        mochilaEntrenador.agregarObjeto(pocionBasica);
        mochilaEntrenador.agregarObjeto(megaPocion);
        mochilaEntrenador.agregarObjeto(hiperPocion);
        mochilaEntrenador.agregarObjeto(curaTotal);
        mochilaEntrenador.agregarObjeto(antiVeneno);
        mochilaEntrenador.agregarObjeto(despertar);
        mochilaEntrenador.agregarObjeto(curarParalisis);
        mochilaEntrenador.agregarObjeto(revivir);
        mochilaEntrenador.agregarObjeto(maxRevivir);
        mochilaEntrenador.agregarObjeto(ataqueX);
        mochilaEntrenador.agregarObjeto(defensaX);
        return mochilaEntrenador;
    }

}
