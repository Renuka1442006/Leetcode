select DISTINCT v1.author_id as id FROM Views v1 
JOIN Views v2 ON v1.author_id=v2.author_id
WHERE v1.author_id=v2.viewer_id
GROUP BY v1.author_id
ORDER BY id;