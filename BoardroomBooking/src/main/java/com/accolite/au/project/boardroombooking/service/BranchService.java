package com.accolite.au.project.boardroombooking.service;

import java.util.List;

import com.accolite.au.project.boardroombooking.model.Branch;

public interface BranchService {
	List<Branch> getAllBranches();
	Branch getBranchById(int id);
	boolean saveBranch(Branch branch);
	boolean updateBranch(Branch branch);
	boolean deleteBranchById(int id);
	boolean deleteBranch(Branch branch);
}
