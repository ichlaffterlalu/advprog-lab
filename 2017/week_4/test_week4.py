import unittest
from week4 import SimpleItem, CompositeItem


class SimpleItemTest(unittest.TestCase):

    def setUp(self):
        self.pencil = SimpleItem("Pencil", 0.40)
        self.ruler = SimpleItem("Ruler", 1.60)
        self.eraser = SimpleItem("Eraser", 0.20)

    def test_create(self):
        self.assertEqual("Pencil", self.pencil.name)
        self.assertEqual("Ruler", self.ruler.name)
        self.assertEqual("Eraser", self.eraser.name)

    def test_composite(self):
        self.assertFalse(self.pencil.composite)
        self.assertFalse(self.ruler.composite)
        self.assertFalse(self.eraser.composite)

    def test_price(self):
        self.assertAlmostEqual(0.40, self.pencil.price)
        self.assertAlmostEqual(1.60, self.ruler.price)
        self.assertAlmostEqual(0.20, self.eraser.price)


class CompositeItemTest(SimpleItemTest):

    def setUp(self):
        super().setUp()
        self.pencilSet = CompositeItem("Pencil Set", self.pencil,
                                       self.ruler, self.eraser)
        self.box = SimpleItem("Box", 1.00)
        self.boxedPencilSet = CompositeItem("Boxed Pencil Set",
                                            self.box, self.pencilSet)
        self.marker = SimpleItem("Marker", 0.40)
        self.boxedPencilSet.add(self.marker)

    def test_create(self):
        self.assertEqual("Pencil Set", self.pencilSet.name)
        self.assertEqual(3, len(self.pencilSet.children))
        self.assertEqual(self.boxedPencilSet.name, "Boxed Pencil Set")

    def test_composite(self):
        self.assertTrue(self.pencilSet.composite)
        self.assertTrue(self.boxedPencilSet.composite)

    def test_price(self):
        self.assertAlmostEqual(2.20, self.pencilSet.price)
        self.assertAlmostEqual(3.60, self.boxedPencilSet.price)

    def test_add_simple_item(self):
        num_before = len(self.boxedPencilSet.children)
        bag = SimpleItem("Bag", 1.00)
        self.boxedPencilSet.add(bag)
        self.assertEqual(num_before + 1, len(self.boxedPencilSet.children))

    def test_remove_simple_item(self):
        num_before = len(self.boxedPencilSet.children)
        self.boxedPencilSet.remove(self.marker)
        self.assertEqual(num_before - 1, len(self.boxedPencilSet.children))
