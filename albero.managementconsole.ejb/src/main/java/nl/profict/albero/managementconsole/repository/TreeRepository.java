/**
 * 
 */
package nl.profict.albero.managementconsole.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import nl.profict.albero.managementconsole.model.TreeJpa;

/**
 * JDBC-based implementer for an Database-repository.
 * 
 * @author wanja
 *
 */
public class TreeRepository  {
	private EntityManager entityManager;
	
	public TreeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findTreeNames() {
		Query query = getEntityManager().createQuery("SELECT t.code FROM " + TreeJpa.class.getName() + " t");
		return  (List<String>)(query.getResultList());
	}

	public TreeJpa getTree(String code) {
		return getEntityManager().find(TreeJpa.class, code);
	}

	public TreeJpa createTree(TreeJpa tree) {
		getEntityManager().persist(tree);
		return tree;
	}

	public void updateTree(TreeJpa tree) {
		TreeJpa existingTree = getEntityManager().find(TreeJpa.class, tree.getCode());
		existingTree.setParser(tree.getParser());
		existingTree.setTree(tree.getTree());
		getEntityManager().merge(existingTree);
	}

	public void deleteTree(String code) {
		TreeJpa tree = getEntityManager().find(TreeJpa.class, code);
		getEntityManager().remove(tree);
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
