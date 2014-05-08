Mark the view that <i>exactly</i> yields the given reference output based on the given table.

<br style="clear: both;" />

<div class="navcontainer">
<ul class="navlist">
<li>

<table class="dbtable">
  <tr><th>employees</th></tr>
  <tr><th>id (int)</th><th>name (text)</th></tr>
  <tr><td>1</td><td>Susan</td></tr>
</table>

</li>
<li>


<table class="dbtable">
  <tr><th>departments</th></tr>
  <tr><th>id (int)</th><th>name (text)</th><th>employee_id (int)</th></tr>
  <tr><td>1</td><td>Development</td><td>1</td></tr>
</table>


</li>
</ul>
</div>

<br style="clear: both;" />


Reference Output (assume the prefixes hold for the whole task):
<textarea style="height: 120px" ui-codemirror="editorOptions.ttl" readonly>
@prefix rdfs: &lt;http://www.w3.org/2000/01/rdf-schema#&gt; .

@prefix e: &lt;http://example.com/employee/&gt; .
@prefix o: &lt;http://example.com/ontology/&gt; .
@prefix d: &lt;http://example.com/department/&gt; .

e:Susan o:isLeaderOf d:Development
</textarea>


<textarea style="height: 220px" ui-codemirror="editorOptions.ttl" readonly>
&lt;EmpToDept&gt;&#13;&#10;
  a rr:TriplesMap ;&#13;&#10;
  rr:logicalTable [ rr:query """&#13;&#10;
      SELECT e.name AS empname, d.name AS deptname&#13;&#10;
          FROM employees e JOIN departments d&#13;&#10;
          ON (d.employee_id = e.id)]]&#13;&#10;
      """ ] ;&#13;&#10;
  rr:subjectMap [&#13;&#10;
    rr:template "http://example.com/employee/\{empname\}"&#13;&#10;
  ] ;&#13;&#10;
  rr:predicateObjectMap [&#13;&#10;
    rr:predicate o:isLeaderOf ;&#13;&#10;
    rr:objectMap [&#13;&#10;
      rr:template "http://example.com/department/\{deptname\}"&#13;&#10;
    ]&#13;&#10;
  ] .
</textarea>



<textarea style="height: 180px" ui-codemirror="editorOptions.ttl" readonly>
&lt;EmpToDept&gt;&#13;&#10;
  a rr:TriplesMap ;&#13;&#10;
  rr:logicalTable [ rr:table "departments" ] ;&#13;&#10;
  rr:subjectMap [&#13;&#10;
    rr:template "http://example.com/employee/\{employee_id\}"&#13;&#10;
  ] ;&#13;&#10;
  rr:predicateObjectMap [&#13;&#10;
    rr:predicate o:isLeaderOf ;&#13;&#10;
    rr:objectMap [&#13;&#10;
      rr:template "http://example.com/department/\{id\}"&#13;&#10;
    ]&#13;&#10;
  ] .
</textarea>



<textarea style="height: 180px" ui-codemirror="editorOptions.ttl" readonly>
&lt;EmpToDept&gt;&#13;&#10;
  a rr:TriplesMap ;&#13;&#10;
  rr:logicalTable [ rr:table "employees" ] ;&#13;&#10;
  rr:subjectMap [&#13;&#10;
    rr:template "http://example.com/employee/\{name\}"&#13;&#10;
  ] ;&#13;&#10;
  rr:predicateObjectMap [&#13;&#10;
    rr:predicate o:isLeaderOf ;&#13;&#10;
    rr:objectMap [&#13;&#10;
      rr:template "http://example.com/department/\{id\}"&#13;&#10;
    ]&#13;&#10;
  ] .
</textarea>



