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
package com.github.britter.beanvalidators.file;

import javax.validation.ConstraintValidatorContext;
import java.io.File;

/**
 * Validator for {@link NotReadable @NotReadable}.
 *
 * @since 0.5.0
 */
public class NotReadableConstraintValidator extends AbstractFileConstraintValidator<NotReadable> {

    @Override
    public void initialize(final NotReadable constraintAnnotation) {
        super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(final File value, final ConstraintValidatorContext context) {
        return !value.canRead();
    }

}