package nl.profict.albero.managementconsole.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nl.profict.albero.managementconsole.model.Tree;
import nl.profict.albero.managementconsole.model.TreeJpa;
import nl.profict.albero.managementconsole.repository.TreeRepository;

@Stateless
public class TreeServiceBean implements TreeService {

	@PersistenceContext(unitName="albero-managementconsole")
	private EntityManager entityManager;

	public List<String> findTreeNames() {
		return new TreeRepository(getEntityManager()).findTreeNames();
	}

	public Tree getTree(String code) {
		return TreeJpaToTree(new TreeRepository(getEntityManager()).getTree(code));
	}

	public Tree createTree(Tree tree) throws Exception {
		return TreeJpaToTree(new TreeRepository(getEntityManager()).createTree(TreeToTreeJpa(tree)));
	}

	public void updateTree(Tree tree) {
		new TreeRepository(getEntityManager()).updateTree(TreeToTreeJpa(tree));
	}

	public void deleteTree(String code) {
		new TreeRepository(getEntityManager()).deleteTree(code);		
	}
	
	private EntityManager getEntityManager() {
		return entityManager;
	}
	
	private TreeJpa TreeToTreeJpa(Tree tree) {
		return new TreeJpa(tree.getCode(), tree.getParser(), tree.getTree());
	}

	private Tree TreeJpaToTree(TreeJpa treeJpa) {
		return new Tree(treeJpa.getCode(), treeJpa.getParser(), treeJpa.getTree());
	}	
}
