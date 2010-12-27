
<#if (fieldErrors?exists && fieldErrors?size >0)||(actionErrors?exists && actionErrors?size > 0)>

<div id="errorMessages">
    <ul>

        <#if (actionErrors?exists && actionErrors?size > 0)>
	        <#list actionErrors as actionError>
                <li>${actionError}</li>
            </#list>
        </#if>

        <#if (fieldErrors?exists && fieldErrors?size >0)>
	            <#list fieldErrors.entrySet() as entry>
                     <#list entry.value as error>
                         <#if error?exists>
                             <li> ${action.getText(error)}</li>
                         </#if>
                   </#list>
                </#list>
        </#if>
    </ul>

</div>
</#if>