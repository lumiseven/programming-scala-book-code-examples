// src/main/scala/progscala3/visibility/ProtectedScope.scala

package progscala3.visibility.protectedscope {

  package scopeA {
    class ProtectedClass1(protected val protectedField1: Int) {
      protected val protectedField2 = 1

      def equalFields(other: ProtectedClass1) =
        (protectedField1 == other.protectedField1) &&
        (protectedField2 == other.protectedField2) &&
        (nested == other.nested)

      class Nested {
        protected val nestedField = 1
      }

      protected val nested = new Nested
    }

    class ProtectedClass2 extends ProtectedClass1(1) {
      val field1 = protectedField1
      val field2 = protectedField2
      // Scope error:
      // val nField = new Nested().nestedField
    }

    class ProtectedClass3 {
      val protectedClass1 = new ProtectedClass1(1)
      // All are scope errors:
      // val protectedField1 = protectedClass1.protectedField1
      // val protectedField2 = protectedClass1.protectedField2
      // val protectedNField = protectedClass1.nested.nestedField
    }

    protected class ProtectedClass4

    class ProtectedClass5 extends ProtectedClass4
    protected class ProtectedClass6 extends ProtectedClass4
  }

  package scopeB {
    // Scope error:
    // class ProtectedClass4B extends scopeA.ProtectedClass4
  }
}
