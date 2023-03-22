package PVBClothing.Service.User;

import org.springframework.stereotype.Service;

import PVBClothing.Entity.User;

@Service
public interface IAccountService {
	public int AddAccount(User user);
	public User CheckAccount(User user);
}
