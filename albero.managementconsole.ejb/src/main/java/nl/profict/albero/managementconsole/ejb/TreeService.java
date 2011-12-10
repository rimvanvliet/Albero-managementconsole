package nl.profict.albero.managementconsole.ejb;

import java.util.List;

import javax.ejb.Local;

import nl.profict.albero.managementconsole.model.Tree;

@Local
public interface TreeService {

	List<String> findTreeNames();

	Tree getTree(String code);

	Tree createTree(Tree tree) throws Exception;

	void updateTree(Tree tree);
	
	void deleteTree(String code);
}
