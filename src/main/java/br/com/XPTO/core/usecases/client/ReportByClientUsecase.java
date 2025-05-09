package br.com.XPTO.core.usecases.client;

import br.com.XPTO.infra.dtos.client.responses.ReportByClient;

public interface ReportByClientUsecase {
    ReportByClient execute(Long id);
}
