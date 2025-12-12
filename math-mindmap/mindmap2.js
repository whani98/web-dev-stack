// The mind map data in JSON format
const mindMapData = {
  nodes: [
    { id: 1, label: "Steven Paul Jobs", group: "Person" },
    { id: 2, label: "Apple", group: "Company" },
    { id: 3, label: "Pixar", group: "Company" },
    { id: 4, label: "NeXT", group: "Company" },
    { id: 5, label: "Personal Computer Revolution", group: "Technology" },
    { id: 6, label: "Apple I", group: "Technology" },
    { id: 7, label: "Apple II", group: "Technology" },
    { id: 8, label: "Xerox Alto", group: "Technology" },
    { id: 9, label: "Apple Lisa", group: "Technology" },
    { id: 10, label: "Macintosh", group: "Technology" },
    { id: 11, label: "Desktop Publishing Industry", group: "Technology" },
    { id: 12, label: "Apple LaserWriter", group: "Technology" },
    { id: 13, label: "NeXTSTEP", group: "Technology" },
    { id: 14, label: "Visual Effects Industry", group: "Technology" },
    { id: 15, label: "Toy Story", group: "Technology" },
    { id: 16, label: "Mac OS X / macOS", group: "Technology" },
    { id: 17, label: "Pancreatic Neuroendocrine Tumor", group: "Medical" },
    { id: 18, label: "Presidential Medal of Freedom", group: "Award" },
    { id: 19, label: "abcdefg1gsf", group: "Person" },
  ],
  edges: [
    { from: 1, to: 2 }, // Steven Paul Jobs -> Apple
    { from: 1, to: 3 }, // Steven Paul Jobs -> Pixar
    { from: 1, to: 4 }, // Steven Paul Jobs -> NeXT
    { from: 1, to: 5 }, // Steven Paul Jobs -> Personal Computer Revolution
    { from: 2, to: 6 }, // Apple -> Apple I
    { from: 2, to: 7 }, // Apple -> Apple II
    { from: 5, to: 8 }, // Personal Computer Revolution -> Xerox Alto
    { from: 5, to: 9 }, // Personal Computer Revolution -> Apple Lisa
    { from: 5, to: 10 }, // Personal Computer Revolution -> Macintosh
    { from: 11, to: 12 }, // Desktop Publishing Industry -> Apple LaserWriter
    { from: 4, to: 13 }, // NeXT -> NeXTSTEP
    { from: 14, to: 15 }, // Visual Effects Industry -> Toy Story
    { from: 16, to: 13 }, // Mac OS X / macOS -> NeXTSTEP
    { from: 1, to: 17 }, // Steven Paul Jobs -> Pancreatic Neuroendocrine Tumor
    { from: 1, to: 18 }, // Steven Paul Jobs -> Presidential Medal of Freedom
  ],
};

// Initialize the network
const container = document.getElementById("mindmap");
const options = {};
const network = new vis.Network(container, mindMapData, options);
