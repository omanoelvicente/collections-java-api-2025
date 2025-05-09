package map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    Map<LocalDate, Evento> agendaEventosMap;

    public AgendaEventos() {
        this.agendaEventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        agendaEventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventoParaExibir = new TreeMap<>(agendaEventosMap);
       for (Map.Entry<LocalDate, Evento> entry : eventoParaExibir.entrySet()) {
           LocalDate dataEvento = entry.getKey();
           Evento evento = entry.getValue();
           System.out.println("Data: " + dataEvento + ", evento " + evento.getNome() + ", atração " + evento.getAtracao());
       }
    }

    public void obterProximoEvento() {
        Evento proximoEvento = null;
        LocalDate proximaData = null;
        LocalDate dataAtual = LocalDate.now();

            for (Map.Entry<LocalDate, Evento> entry : agendaEventosMap.entrySet()) {
                LocalDate dataEvento = entry.getKey();
                if (dataEvento.isEqual(dataAtual) || dataEvento.isAfter(dataAtual)) {
                    proximaData = dataEvento;
                    proximoEvento = entry.getValue();

                }
            }
        if (proximoEvento != null) {
            System.out.println("O próximo evento: " + proximoEvento.getNome() + " será na data: " + proximaData);
        }else {
            System.out.println("Não há eventos futuros na agenda");
        }
    }

    public static void main(String[] args) {
        AgendaEventos agenda = new AgendaEventos();

        agenda.adicionarEvento(LocalDate.of(2025, Month.APRIL,2),"Rock in roça","CPM22");
        agenda.adicionarEvento(LocalDate.of(2025, 5,26),"Tardezinha","Menos é mais");
        agenda.adicionarEvento(LocalDate.of(2025, Month.AUGUST,10),"Futuristica","Alok");
        agenda.adicionarEvento(LocalDate.of(2025, 7,2),"Sistema bruto","Jorge e Mateus");
       // agenda.adicionarEvento(LocalDate.of(2025, Month.MAY,10),"Circuito reggae","Planta e Raiz");

        agenda.exibirAgenda();

        agenda.obterProximoEvento();
    }
}
