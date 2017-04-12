
	//通过id，返回节点
	function $a(id){
		return document.getElementById(id)	
	}
	//通过id返回对应节点的value属性值
	function $F(id){
		return $a(id).value;
	}
	function $N(name){
		return document.getElementsByName(name);
	}
	function $R(name)
	{
		var radios = $N(name);
		var val;
		for(radio in radios) {
		   if(radios[radio].checked) {
		      val = radios[radio].value;
		      return val;
		   }
		}
	}
	
	function kk()
	{//
		$a("tt").style.display="none";
	}
	function kk1()
	{
		$a("tt").style.display="block";
	}