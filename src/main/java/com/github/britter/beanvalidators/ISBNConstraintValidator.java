/*
 * Copyright 2015 Benedikt Ritter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.britter.beanvalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.ISBNValidator;

public class ISBNConstraintValidator implements ConstraintValidator<ISBN, String> {

    private ISBNType type;

    @Override
    public void initialize(ISBN constraintAnnotation) {
        this.type = constraintAnnotation.type();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Don't validate null, empty and blank strings, since these are validated by @NotNull, @NotEmpty and @NotBlank
        if(StringUtils.isBlank(value)) {
            return true;
        }
        
        switch (type) {
            case ISBN_10: return ISBNValidator.getInstance().isValidISBN10(value);
            case ISBN_13: return ISBNValidator.getInstance().isValidISBN13(value);
            default: return ISBNValidator.getInstance().isValid(value);
        }
    }

}
