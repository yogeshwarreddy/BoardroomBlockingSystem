package com.accolite.au.project.boardroombooking.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.au.project.boardroombooking.model.BookingRequest;
import com.accolite.au.project.boardroombooking.model.Branch;
import com.accolite.au.project.boardroombooking.model.Role;
import com.accolite.au.project.boardroombooking.model.User;
import com.accolite.au.project.boardroombooking.repository.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserDao userDao;
	@Autowired
	private RoleService roleService;	
	@Autowired
	private BranchService branchService;
	
/*	@Autowired
	private BookingRequestService bookingRequestService; */
	
	@Override
	   public List<User> getAllUsers() {
	      return userDao.getAllUsers();
	   }


	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}


	@Override
	public boolean saveUser(User user) {
		Set<Role> roles = user.getRoles();
		Role employee = roleService.getRoleById(1);
		roles.add(employee);
		employee.getUsers().add(user);
		user.setRoles(roles);
		Branch branch = user.getBranch();
		if(branch!=null) {
			branch = branchService.getBranchById(branch.getId());
			if(branch==null) {
				throw new RuntimeException("Bad Request Can't create Branch");
			}
			branch.getUsers().add(user);
		}
		user.setBranch(branch);
		return userDao.saveUser(user);
	}

	@Override
	public boolean saveAdmin(User user) {
		Set<Role> roles = user.getRoles();
		Role admin = roleService.getRoleById(2);
		roles.add(admin);
		admin.getUsers().add(user);
		user.setRoles(roles);
		return userDao.saveUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}


	@Override
	public boolean deleteUserById(int id) {
		/*List<BookingRequest> requests = bookingRequestService.getAllRequests();
		for(int i = 0;i < requests.size() ; i++) {
			if(id == requests.get(i).getUser().getId()) {
				bookingRequestService.deleteRequest(requests.get(i));
			}
		}*/
		return userDao.deleteUserById(id);
	}


	@Override
	public boolean deleteUser(User user) {
		return userDao.deleteUser(user);
	}


}
