package ar.edu.unq.po2.tpFinal.naviera;

import ar.edu.unq.po2.tpFinal.BuqueInterface;
import ar.edu.unq.po2.tpFinal.circuito.CircuitoMaritimoInterface;
import ar.edu.unq.po2.tpFinal.viaje.ViajesInterface;

import java.util.ArrayList;
import java.util.List;

public class Naviera {
    private List<BuqueInterface> buques;
    private List<CircuitoMaritimoInterface> circuitos;
    private List<ViajesInterface> viajes;

    public Naviera() {
        this.buques = new ArrayList<>();
        this.circuitos = new ArrayList<>();
        this.viajes = new ArrayList<>();
    }

    public void agregarBuque(BuqueInterface buque) {
        this.buques.add(buque);
    }

    public void agregarCircuito(CircuitoMaritimoInterface circuito) {
        this.circuitos.add(circuito);
    }

    public void agregarViaje(ViajesInterface viaje) {
        this.viajes.add(viaje);
    }

    public List<BuqueInterface> getBuques() {
        return this.buques;
    }

    public List<CircuitoMaritimoInterface> getCircuitos() {
        return this.circuitos;
    }

    public List<ViajesInterface> getViajes() {
        return this.viajes;
    }

}