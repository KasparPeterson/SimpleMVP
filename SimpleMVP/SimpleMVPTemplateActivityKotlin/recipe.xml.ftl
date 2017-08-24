<?xml version="1.0"?>
<recipe>

    <instantiate from="src/app_package/Contract.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Contract.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${className}Contract.kt" />

    <instantiate from="src/app_package/Presenter.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Presenter.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${className}Presenter.kt" />

    <instantiate from="src/app_package/Activity.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Activity.kt" />

    <open file="${escapeXmlAttribute(srcOut)}/${className}Activity.kt" />

    <#if includeView>
      <instantiate from="res/layout/view.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/${classToResource(className)}_view.xml" />

      <open file="${escapeXmlAttribute(resOut)}/layout/${classToResource(className)}_view.xml" />

      <instantiate from="src/app_package/View.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}View.kt" />

      <open file="${escapeXmlAttribute(srcOut)}/${className}View.kt" />

      <instantiate from="src/app_package/ViewState.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}ViewState.kt" />

      <open file="${escapeXmlAttribute(srcOut)}/${className}ViewState.kt" />
    </#if>

</recipe>