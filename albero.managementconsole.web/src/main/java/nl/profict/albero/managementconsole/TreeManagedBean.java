package nl.profict.albero.managementconsole;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import nl.profict.albero.managementconsole.ejb.TreeService;
import nl.profict.albero.managementconsole.model.Tree;

public class TreeManagedBean {
	
	@EJB
	private TreeService treeService;

	private String code;

	private Tree tree;
		
	public List<String> getTreeNames() {
		return treeService.findTreeNames();
	}
	
	public String getCode() {
		return code;
	}

	public boolean isCodeLeeg() {
		return tree.getCode()== null || tree.getCode().equals("");
	}
	
	public boolean isCodeGevuld() {
		return !isCodeLeeg();
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	
	public String refresh() {
		code = null;
		tree = new Tree();
		return "list_trees";
	}

	public String editTree() {
		tree = treeService.getTree(code);
		return "tree";
	}

	public String newTree() {
		code = null;
		tree = new Tree();
		tree.setParser("groovy");
		return "tree";
	}
	
	public String createTree() {
		try {
			treeService.createTree(tree);
		} catch (Exception e) {
			this.tree.setCode("");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("javax.faces.component.UIInput.REQUIRED"));
			return "tree";
		}
		return "list_trees";
	}
	
	public String updateTree() {
		treeService.updateTree(tree);
		return "list_trees";
	}
	
	public String deleteTree() {
		treeService.deleteTree(code);
		return "list_trees";
	}	
}
