//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> <STRUCT>
 * f1 -> [ Identifier() ]
 * f2 -> "{"
 * f3 -> ( DeclarationStmt() )*
 * f4 -> "}"
 * f5 -> ";"
 */
public class StructDeclaration implements Node {
   public NodeToken f0;
   public NodeOptional f1;
   public NodeToken f2;
   public NodeListOptional f3;
   public NodeToken f4;
   public NodeToken f5;

   public StructDeclaration(NodeToken n0, NodeOptional n1, NodeToken n2, NodeListOptional n3, NodeToken n4, NodeToken n5) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
   }

   public StructDeclaration(NodeOptional n0, NodeListOptional n1) {
      f0 = new NodeToken("struct");
      f1 = n0;
      f2 = new NodeToken("{");
      f3 = n1;
      f4 = new NodeToken("}");
      f5 = new NodeToken(";");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}
