Mark the view that <i>exactly</i> yields the given reference output based on the given table.

<br style="clear: both;" />

<div class="navcontainer">
<ul class="navlist">
<li>


<table class="dbtable">
  <tr><th>departments</th></tr>
  <tr><th>id (int)</th><th>name (text)</th></tr>
  <tr><td>1</td><td>Development</td></tr>
</table>

</li>
<li>

<table class="dbtable">
  <tr><th>employees</th></tr>
  <tr><th>id (int)</th><th>name (text)</th><th>department_id (int)</th></tr>
  <tr><td>1</td><td>Susan</td><td>1</td></tr>
</table>

</li>
</ul>
</div>

<br style="clear: both;" />


Reference Output (assume the prefixes hold for the whole task):
<textarea style="height: 80px" ui-codemirror="editorOptions.ttl" readonly>
@prefix d: &lt;http://example.com/department/&gt; .
@prefix o: &lt;http://example.com/ontology/&gt; .
@prefix e: &lt;http://example.com/employee/&gt; .

d:Development o:hasEmployee e:Susan .
</textarea>


<textarea style="height: 150px" ui-codemirror="editorOptions.sml" readonly>
Create View DeptToEmp As&#13;&#10;
  Construct {&#13;&#10;
    ?s o:hasEmployee ?o&#13;&#10;
  }&#13;&#10;
  With&#13;&#10;
    ?s = uri(d:, ?deptname)&#13;&#10;
    ?o = uri(e:, ?empname)&#13;&#10;
  From&#13;&#10;
    [[SELECT d.name AS deptname, e.name AS empname FROM departments d JOIN employees e ON (e.department_id = d.id)]]&#13;&#10;
</textarea>

<textarea style="height: 150px" ui-codemirror="editorOptions.sml" readonly>
Create View DeptToEmp As&#13;&#10;
  Construct {&#13;&#10;
    ?s o:hasEmployee ?o&#13;&#10;
  }&#13;&#10;
  With&#13;&#10;
    ?s = uri(d:, ?department_id)&#13;&#10;
    ?o = uri(e:, ?id)&#13;&#10;
  From&#13;&#10;
    employees
</textarea>

<textarea style="height: 150px" ui-codemirror="editorOptions.sml" readonly>
Create View DeptToEmp As&#13;&#10;
  Construct {&#13;&#10;
    ?s o:hasEmployee ?o&#13;&#10;
  }&#13;&#10;
  With&#13;&#10;
    ?s = uri(d:, ?name)&#13;&#10;
    ?o = uri(e:, ?id)&#13;&#10;
  From&#13;&#10;
    departments
</textarea>



