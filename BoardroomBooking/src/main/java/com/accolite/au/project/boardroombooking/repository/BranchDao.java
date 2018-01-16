package com.accolite.au.project.boardroombooking.repository;

import java.util.List;

import com.accolite.au.project.boardroombooking.model.Branch;

public interface BranchDao {
	public List<Branch> getAllBranches();
	public Branch getBranchById(int id);
	public boolean saveBranch(Branch branch);
	public boolean updateBranch(Branch branch);
	public boolean deleteBranchById(int id);
	public boolean deleteBranch(Branch branch);
}
