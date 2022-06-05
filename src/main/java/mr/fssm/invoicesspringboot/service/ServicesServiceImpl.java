package mr.fssm.invoicesspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.fssm.invoicesspringboot.Dto.ServiceDto;
import mr.fssm.invoicesspringboot.entities.Services;
import mr.fssm.invoicesspringboot.exceptions.ProductNotFoundException;
import mr.fssm.invoicesspringboot.repository.ServicesRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ServicesServiceImpl implements ServicesService {
    private final ServicesRepo servicesRepo;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public ServiceDto createService(ServiceDto serviceDto) {
        log.info("Saving new Services");

        Services services = modelMapper.map(serviceDto, Services.class);
        Services newServices= servicesRepo.save(services);
        ServiceDto savedServices= modelMapper.map(newServices, ServiceDto.class);
        return savedServices;
    }
    @Override
    public ServiceDto getService(Long id) throws ProductNotFoundException {
        Services services = servicesRepo.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Service not found"));
        return modelMapper.map(services, ServiceDto.class);
    }
    @Override
    public List<ServiceDto> listServices() {
        List <Services> services = servicesRepo.findAll();
        List <ServiceDto> serviceDtos = services.stream()
                .map(service -> modelMapper.map(service, ServiceDto.class))
                .collect(Collectors.toList());
        return serviceDtos;
    }
    @Override
    public ServiceDto updateService(Long id, ServiceDto serviceDto) throws ProductNotFoundException {
        log.info("update Service");
        Services services = servicesRepo.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Service not found"));
        services = modelMapper.map(serviceDto, Services.class);
        Services savedService = servicesRepo.save(services);
        return modelMapper.map(savedService, ServiceDto.class);
    }
    @Override
    public void deleteService(Long id){
        servicesRepo.deleteById(id);
    }

}
