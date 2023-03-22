package PVBClothing.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PVBClothing.DAO.UserDao;
import PVBClothing.Entity.User;

@Service
public class AccountServiceImp implements IAccountService {
	
	@Autowired
	UserDao userDao = new UserDao();

	@Override
	public int AddAccount(User user) {
		// TODO Auto-generated method stub				
		user.setPasword(BCrypt.hashpw(user.getPasword(), BCrypt.gensalt(12)));
		return userDao.AddAccount(user);
		
	}

	@Override
	public User CheckAccount(User user) {
		String password = user.getPasword();
		user = userDao.GetAccountUser(user);
		if(user != null) {
			if(BCrypt.checkpw(password, user.getPasword())) {
				return user;
			}else {
				return null;
			}
			
		}
		return null;
	}
	
}
