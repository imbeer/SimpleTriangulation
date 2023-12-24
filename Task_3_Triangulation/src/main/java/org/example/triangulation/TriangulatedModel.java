package org.example.triangulation;

import cg.vsu.render.math.vector.Vector2f;
import cg.vsu.render.math.vector.Vector3f;
import org.example.model.Model;
import org.example.model.Polygon;

import java.util.List;

public class TriangulatedModel extends Model {
    private List<Polygon> triangles;

    public TriangulatedModel(
            List<Vector3f> vertices,
            List<Vector3f> normals,
            List<Vector2f> textureVertices,
            List<Polygon> polygons,
            List<Polygon> triangles) {

        super(vertices, normals, textureVertices, polygons);
        this.triangles = triangles;
    }

    public TriangulatedModel(
            List<Vector3f> vertices,
            List<Vector3f> normals,
            List<Vector2f> textureVertices,
            List<Polygon> polygons) {

        super(vertices, normals, textureVertices, polygons);
        this.triangles = Triangulation.triangulateList(polygons);
    }

    public List<Polygon> getTriangles() {
        return triangles;
    }

    public void setTriangles(List<Polygon> triangles) {
        this.triangles = triangles;
    }

    @Override
    public void setPolygons(List<Polygon> polygons) {
        super.setPolygons(polygons);
        setTriangles(Triangulation.triangulateList(polygons));
    }
}
