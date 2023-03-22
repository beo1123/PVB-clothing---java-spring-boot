package PVBClothing.Service.User;

import org.springframework.stereotype.Service;

import PVBClothing.DTO.PaginateDto;

@Service
public class PaginateServiceImp implements IPaginateService {
	public PaginateDto GetInfoPage(int totalData, int limit, int currentPage) {
		PaginateDto page = new PaginateDto();		
		page.setCurrentPage(CheckCurrentPage(currentPage, page.getTotalPage()));
		page.setLimit(limit);
		page.setTotalPage(SetInfoTotalPage(totalData, limit));
		
		page.setStart(FindStart(page.getCurrentPage(), limit));
		page.setEnd(FindEnd(page.getStart(), limit, totalData));
		
		return page;
	}
	
	
	private int FindEnd(int start, int limit, int totalData) {
		// TODO Auto-generated method stub
		
		return start + limit > totalData ? totalData : (start + limit) - 1;
	}


	private int FindStart(int currentPage, int limit) {
		// TODO Auto-generated method stub
		return ((currentPage - 1) * limit) + 1;
	}


	public int SetInfoTotalPage(int totalData, int limit) {
		int totalPage = 0;
		
		totalPage = totalData / limit;
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}
	
	public int CheckCurrentPage(int currentPage, int totalPage) {
		if(currentPage < 1) {
			return 1;
		}
		if (currentPage < totalPage) {
			return totalPage;
		}
		
		return currentPage;
	}
}
