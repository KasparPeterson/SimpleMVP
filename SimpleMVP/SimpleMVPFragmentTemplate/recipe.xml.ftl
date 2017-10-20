<?xml version="1.0"?>
<recipe>

    <instantiate from="src/app_package/Contract.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Contract.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${className}Contract.kt" />

    <instantiate from="src/app_package/Presenter.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Presenter.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${className}Presenter.kt" />

    <instantiate from="src/app_package/Fragment.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Fragment.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${className}Fragment.kt" />

    <#if addState>
    <instantiate from="src/app_package/State.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}State.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${className}State.kt" />
    </#if>

    <instantiate from="res/layout/fragment.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/fragment_${classToResource(className)}.xml" />

    <open file="${escapeXmlAttribute(resOut)}/layout/fragment_${classToResource(className)}.xml" />

</recipe>