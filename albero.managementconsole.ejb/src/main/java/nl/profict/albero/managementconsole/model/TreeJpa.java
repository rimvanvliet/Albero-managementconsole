package nl.profict.albero.managementconsole.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Class to store information from the TREES-Table.
 * 
 * @author wanja
 */
@Entity
@Table(name = "trees")
public class TreeJpa  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id	
	private String code;
	private String parser;
	@Lob
	private String tree;
	
	public TreeJpa() {
		
	}
	
	public TreeJpa(String code, String parser, String tree) {
		this.code = code;
		this.parser = parser;
		this.tree = tree;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParser() {
		return parser;
	}

	public void setParser(String parser) {
		this.parser = parser;
	}

	public String getTree() {
		return tree;
	}

	public void setTree(String tree) {
		this.tree = tree;
	}
}
