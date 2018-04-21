/**
 * 
 */
/**
 * @author amit patil
 *
 */
@GenericGenerator(name = "native_identity_generator", strategy = "native")
@GenericGenerator(name = "sequence_identity_generator", strategy = "sequence")
@GenericGenerator(name = "sequence_identity_identity_generator", strategy = "sequence-identity")
@GenericGenerator(name = "enhanced_sequence_identity_generator", strategy = "enhanced-sequence")
package com.example.hibernate.model.identity.hibernate;

import org.hibernate.annotations.GenericGenerator;
