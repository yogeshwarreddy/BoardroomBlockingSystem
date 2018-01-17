package com.accolite.au.project.boardroombooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.au.project.boardroombooking.model.Branch;
import com.accolite.au.project.boardroombooking.repository.BranchDao;

@Service
@Transactional
public class BranchServiceImpl implements BranchService{
	
	@Autowired
	private BranchDao branchDao;

	@Override
	public List<Branch> getAllBranches() {
		return branchDao.getAllBranches();
	}

	@Override
	public Branch getBranchById(int id) {
		return branchDao.getBranchById(id);
	}

	@Override
	public boolean saveBranch(Branch branch) {
		return branchDao.saveBranch(branch);
	}

	@Override
	public boolean updateBranch(Branch branch) {
		return branchDao.updateBranch(branch);
	}

	@Override
	public boolean deleteBranchById(int id) {
		return branchDao.deleteBranchById(id);
	}

	@Override
	public boolean deleteBranch(Branch branch) {
		return branchDao.deleteBranch(branch);
	}

}
