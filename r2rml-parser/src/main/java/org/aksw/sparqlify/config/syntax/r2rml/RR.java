/**
 * 
 */
package org.aksw.sparqlify.config.syntax.r2rml;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

/**
 * The R2RML vocabulary
 * 
 * @author sherif
 *
 */
public class RR {
	public static final String rr = "http://www.w3.org/ns/r2rml#";

	private static Property property(String name) {
		Property result = ResourceFactory.createProperty(rr + name);
		return result;
	}
	
	public static String getURI(){ return rr;	}
	
	public static final Property child 				= property("child");
	public static final Property rrClass 				= property("class");
	public static final Property column 				= property("column");
	public static final Property datatype 			= property("datatype");
	public static final Property constant 			= property("constant");
	public static final Property graph 				= property("graph");
	public static final Property graphMap 			= property("graphMap");
	public static final Property inverseExpression 	= property("inverseExpression");
	public static final Property joinCondition 		= property("joinCondition");
	public static final Property language 			= property("language");
	public static final Property logicalTable 		= property("logicalTable");
	public static final Property object 				= property("object");
	public static final Property objectMap 			= property("objectMap");
	public static final Property parent 				= property("parent");
	public static final Property parentTriplesMap 	= property("parentTriplesMap");
	public static final Property predicate 			= property("predicate");
	public static final Property predicateMap 		= property("predicateMap");
	public static final Property predicateObjectMap	= property("predicateObjectMap");
	public static final Property sqlQuery 			= property("sqlQuery");
	public static final Property sqlVersion 			= property("sqlVersion");
	public static final Property subject 				= property("subject");
	public static final Property subjectMap 			= property("subjectMap");
	public static final Property tableName			= property("tableName");
	public static final Property template 			= property("template");
	public static final Property termType 			= property("termType");
	public static final Property BlankNode			= property("BlankNode");	
	
	// Other Terms
//	public static final Property defaultGraph 		= property("defaultGraph");
//	public static final Property SQL2008 				= property("SQL2008");
//	public static final Property IRI 					= property("IRI");

//	public static final Property Literal 				= property("Literal");
}