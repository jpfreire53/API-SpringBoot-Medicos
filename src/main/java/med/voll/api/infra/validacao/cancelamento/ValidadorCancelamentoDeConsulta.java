package med.voll.api.infra.validacao.cancelamento;


import med.voll.api.domain.consulta.dto.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);

}
