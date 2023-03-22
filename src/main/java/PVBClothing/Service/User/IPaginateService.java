package PVBClothing.Service.User;

import org.springframework.stereotype.Service;

import PVBClothing.DTO.PaginateDto;

@Service
public interface IPaginateService {
	public PaginateDto GetInfoPage(int totalData, int limit, int currentPage);
	
}
