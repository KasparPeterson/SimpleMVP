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

    <#if includeLayout>
      <instantiate from="res/layout/activity.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/activity_${classToResource(className)}.xml" />

      <open file="${escapeXmlAttribute(resOut)}/layout/activity_${classToResource(className)}.xml" />
    </#if>

</recipe>