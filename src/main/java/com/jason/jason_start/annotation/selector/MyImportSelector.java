package com.jason.jason_start.annotation.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Author: Jason
 * Date 2020/7/19
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.jason.jason_start.annotation.InfoMain"};
    }
}
