package med.voll.api.infra.validacao.agendamento;

import med.voll.api.domain.consulta.dto.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {

    void validar(DadosAgendamentoConsulta dados);

}
