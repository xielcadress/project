package com.Enum;


public class Test {
	public static void main(String[] args) {
		HyEnum[] t= HyEnum.values();
		System.out.println(t[0].getValue());
		System.out.println(t[1].getValue());
		/**
		  model.addAttribute("industrys", HyEnum.values());
		 */
		/** 
		 <c:forEach var="t" items="${industrys }">
		  <option value="${t }">${t.value }</option>
	     </c:forEach>
	    */
	}
}
