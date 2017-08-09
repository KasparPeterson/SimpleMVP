<?xml version="1.0"?>
<recipe>

    <instantiate from="src/app_package/Contract.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Contract.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${className}Contract.java" />

    <instantiate from="src/app_package/Presenter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Presenter.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${className}Presenter.java" />

    <instantiate from="src/app_package/Activity.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Activity.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${className}Activity.java" />

    <instantiate from="res/layout/activity.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/activity_${classToResource(className)}.xml" />

    <open file="${escapeXmlAttribute(resOut)}/layout/activity_${classToResource(className)}.xml" />

</recipe>