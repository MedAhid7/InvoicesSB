package mr.fssm.invoicesspringboot.service;

import mr.fssm.invoicesspringboot.Dto.ServiceDto;
import mr.fssm.invoicesspringboot.exceptions.ProductNotFoundException;

import java.util.List;

public interface ServicesService {
    ServiceDto createService(ServiceDto serviceDto);

    ServiceDto getService(Long id) throws ProductNotFoundException;

    List<ServiceDto> listServices();

    ServiceDto updateService(Long id, ServiceDto serviceDto) throws ProductNotFoundException;

    void deleteService(Long id);
}
