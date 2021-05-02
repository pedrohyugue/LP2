#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);
typedef int  (* Figure_Mediacentral)  (struct Figure*);

typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
    int  (* mediacentral)  (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d) e area (%d) e com ponto central em (%d,%d).\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->mediacentral(sup));
}

int rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}
int rect_mediacentral (Rect* this) {
	Figure* sup = (Figure*) this;
	int compx,compy;
	compx= this->w - sup->x;
	compy= this->h - sup->y;
    return compx/2, compy/2;
}

Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area)  rect_area,
    (Figure_Mediacentral)  rect_mediacentral
};

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d) e area (%d) e com ponto central em (%d,%d).\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->mediacentral(sup));
}

int ellipse_area (Ellipse* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}
int ellipse_mediacentral (Ellipse* this) {
	Figure* sup = (Figure*) this;
	int compx,compy;
	compx= this->w - sup->x;
	compy= this->h - sup->y;
    return compx/2, compy/2;
}

Figure_vtable ellipse_vtable = {
    (Figure_Print) ellipse_print,
    (Figure_Area)  ellipse_area,
	(Figure_Mediacentral)  ellipse_mediacentral
};

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
    int ai, af;
} Arc;

void arc_print (Arc* this) {
    Figure* sup = (Figure*) this;
    printf("Arco de tamanho (%d,%d) e angulatura(%d,%d) na posicao (%d,%d) com area (%d) e com ponto central em (%d,%d).\n",
           this->w, this->h, sup->x, sup->y,this->ai,this->af, sup->vtable->area(sup), sup->vtable->mediacentral(sup));
}
int arc_area (Arc* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}
int arc_mediacentral (Arc* this) {
	Figure* sup = (Figure*) this;
	int compx,compy;
	compx= this->w - sup->x;
	compy= this->h - sup->y;
    return compx/2, compy/2;
}
Figure_vtable arc_vtable = {
    (Figure_Print) arc_print,
    (Figure_Area)  arc_area,
    (Figure_Mediacentral)  arc_mediacentral
};

Arc* arc_new (int x, int y, int w, int h,int ai,int af) {
    Arc* this = malloc(sizeof(Arc));
    Figure* sup = (Figure*) this;
    sup->vtable = &arc_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->ai = ai;
    this->af = af;
}
////////////////////////////////////////////////////////////////////////////////
typedef struct {
    Figure super;
    int x2, y2;
} Line;

void line_print (Line* this) {
    Figure* sup = (Figure*) this;
    printf("Line de tamanho (%d,%d) na posicao (%d,%d) com area (%d) e com ponto central da figura em (%d,%d).\n",
           this->x2, this->y2, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->mediacentral(sup));
}
int line_area (Line* this) {
    Figure* sup = (Figure*) this;
    return this->x2 * this->y2;
}
int line_mediacentral (Line* this) {
	Figure* sup = (Figure*) this;
	int compx,compy;
	compx= this->x2 - sup->x;
	compy= this->y2 - sup->y;
    return compx/2, compy/2;
}
Figure_vtable line_vtable = {
    (Figure_Print) line_print,
    (Figure_Area)  line_area,
    (Figure_Mediacentral)  line_mediacentral,
};
Line* line_new (int x, int y, int x2, int y2) {
    Line* this = malloc(sizeof(Line));
    Figure* sup = (Figure*) this;
    sup->vtable = &line_vtable;
    sup->x = x;
    sup->y = y;
    this->x2 = x2;
    this->y2 = y2;
}
////////////////////////////////////////////////////////////////////////
void main (void) {
	int i;
    Figure* figs[4] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) arc_new(10,10,100,100,30,50),
        (Figure*) line_new(210,110,305,130)
    };

    ///

    for (i=0; i<4; i++) {
        figs[i]->vtable->print(figs[i]);
    }

    ///

    for (i=0; i<4; i++) {
        free(figs[i]);
    }
}
