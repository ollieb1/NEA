select * from curve_point;

select * from role;

select * from curve;

delete from curve_point where id < 1000;

delete from curve where id < 1000;

insert into curve values (1,sysdate(),sysdate(),1,1,'USD','2021-03-01',0,'USD_3M',1);

insert into curve_point values (1,1,0.0014712,1);
insert into curve_point values (2,186,0.0016645,1);
insert into curve_point values (3,367,0.0018013,1);
insert into curve_point values (4,735,0.0022106,1);
insert into curve_point values (5,1099,0.0038186,1);
insert into curve_point values (6,1463,0.0060624,1);
insert into curve_point values (7,1828,0.0081622,1);
insert into curve_point values (8,2193,0.0101128,1);
insert into curve_point values (9,2559,0.0118122,1);
insert into curve_point values (10,2926,0.0132167,1);
insert into curve_point values (11,3290,0.0143838,1);
insert into curve_point values (12,3654,0.0153729,1);
insert into curve_point values (13,4385,0.0169446,1);
insert into curve_point values (14,5481,0.0184179,1);
insert into curve_point values (15,7308,0.019587,1);
insert into curve_point values (16,9135,0.0199906,1);
insert into curve_point values (17,10962,0.0201237,1);
insert into curve_point values (18,14612,0.0193257,1);

insert into curve values (2,sysdate(),sysdate(),1,1,'USD','2021-03-02',0,'USD_3M',1);

insert into curve_point values (19,1,0.0014712,2);
insert into curve_point values (20,188,0.0016748,2);
insert into curve_point values (21,370,0.0018087,2);
insert into curve_point values (22,734,0.0021969,2);
insert into curve_point values (23,1098,0.0036955,2);
insert into curve_point values (24,1463,0.0058111,2);
insert into curve_point values (25,1828,0.0078271,2);
insert into curve_point values (26,2193,0.097392,2);
insert into curve_point values (27,2561,0.0114367,2);
insert into curve_point values (28,2925,0.0128184,2);
insert into curve_point values (29,3289,0.0139895,2);
insert into curve_point values (30,3654,0.0149829,2);
insert into curve_point values (31,4388,0.0166034,2);
insert into curve_point values (32,5481,0.0181446,2);
insert into curve_point values (33,7307,0.019372,2);
insert into curve_point values (34,9134,0.0198182,2);
insert into curve_point values (35,10961,0.0199889,2);
insert into curve_point values (36,14615,0.0191873,2);

insert into curve values (3,sysdate(),sysdate(),1,1,'USD','2021-03-03',0,'USD_3M',1);

insert into curve_point values (37,1,0.0014712,3);
insert into curve_point values (38,187,0.0017488,3);
insert into curve_point values (39,369,0.0018847,3);
insert into curve_point values (40,733,0.0023515,3);
insert into curve_point values (41,1098,0.0040458,3);
insert into curve_point values (42,1463,0.006326,3);
insert into curve_point values (43,1828,0.0084835,3);
insert into curve_point values (44,2196,0.0104981,3);
insert into curve_point values (45,2560,0.0122521,3);
insert into curve_point values (46,2924,0.013696,3);
insert into curve_point values (47,3289,0.0148971,3);
insert into curve_point values (48,3654,0.0159262,3);
insert into curve_point values (49,4387,0.0175452,3);
insert into curve_point values (50,5481,0.0190786,3);
insert into curve_point values (51,7307,0.0202887,3);
insert into curve_point values (52,9133,0.0207204,3);
insert into curve_point values (53,10960,0.0208821,3);
insert into curve_point values (54,14614,0.0200612,3);

insert into curve values (4,sysdate(),sysdate(),1,1,'USD','2021-03-04',0,'USD_3M',1);

insert into curve_point values (55,1,0.0014712,4);
insert into curve_point values (56,188,0.001708,4);
insert into curve_point values (57,369,0.0018543,4);
insert into curve_point values (58,734,0.0023741,4);
insert into curve_point values (59,1100,0.0042725,4);
insert into curve_point values (60,1467,0.0067528,4);
insert into curve_point values (61,1831,0.0090852,4);
insert into curve_point values (62,2195,0.0112008,4);
insert into curve_point values (63,2561,0.0130369,4);
insert into curve_point values (64,2926,0.0145263,4);
insert into curve_point values (65,3294,0.0157737,4);
insert into curve_point values (66,3658,0.016816,4);
insert into curve_point values (67,4387,0.0183762,4);
insert into curve_point values (68,5485,0.0198245,4);
insert into curve_point values (69,7312,0.0209213,4);
insert into curve_point values (70,9135,0.0212781,4);
insert into curve_point values (71,10961,0.0213888,4);
insert into curve_point values (72,14614,0.0205614,4);

insert into curve values (5,sysdate(),sysdate(),1,1,'USD','2021-03-05',0,'USD_3M',1);

insert into curve_point values (73,3,0.0014712,5);
insert into curve_point values (74,188,0.0017338,5);
insert into curve_point values (75,369,0.0018801,5);
insert into curve_point values (76,734,0.0024009,5);
insert into curve_point values (77,1102,0.0043185,5);
insert into curve_point values (78,1466,0.0067899,5);
insert into curve_point values (79,1830,0.0090973,5);
insert into curve_point values (80,2195,0.0112029,5);
insert into curve_point values (81,2561,0.0129968,5);
insert into curve_point values (82,2929,0.0144486,5);
insert into curve_point values (83,3293,0.015652,5);
insert into curve_point values (84,3657,0.0166501,5);
insert into curve_point values (85,4387,0.018199,5);
insert into curve_point values (86,5484,0.0196244,5);
insert into curve_point values (87,7311,0.0207047,5);
insert into curve_point values (88,9138,0.0210575,5);
insert into curve_point values (89,10961,0.0211499,5);
insert into curve_point values (90,14614,0.0203387,5);

insert into curve values (6,sysdate(),sysdate(),1,1,'GBP','2021-03-01',1,'GDP_6M',1);

insert into curve_point values (91,1,0.0010005,6);
insert into curve_point values (92,184,0.0009102,6);
insert into curve_point values (93,365,0.0009549,6);
insert into curve_point values (94,730,0.0024635,6);
insert into curve_point values (95,1096,0.0037758,6);
insert into curve_point values (96,1463,0.0050026,6);
insert into curve_point values (97,1827,0.0060628,6);
insert into curve_point values (98,2191,0.0069492,6);
insert into curve_point values (99,2557,0.0077224,6);
insert into curve_point values (100,3654,0.0096386,6);
insert into curve_point values (101,4383,0.0104786,6);
insert into curve_point values (102,5481,0.0112095,6);
insert into curve_point values (103,7308,0.0116599,6);
insert into curve_point values (104,9131,0.0116651,6);
insert into curve_point values (105,10957,0.0114611,6);
insert into curve_point values (106,14610,0.0108215,6);
insert into curve_point values (107,18263,0.0102244,6);
insert into curve_point values (108,21917,0.0099515,6);

insert into curve values (7,sysdate(),sysdate(),1,1,'GBP','2021-03-02',1,'GDP_6M',1);

insert into curve_point values (109,1,0.0009004,7);
insert into curve_point values (110,184,0.0008902,7);
insert into curve_point values (111,365,0.0009051,7);
insert into curve_point values (112,730,0.0023632,7);
insert into curve_point values (113,1098,0.0036249,7);
insert into curve_point values (114,1462,0.0047501,7);
insert into curve_point values (115,1826,0.0057227,7);
insert into curve_point values (116,2191,0.0065573,7);
insert into curve_point values (117,2557,0.0073144,7);
insert into curve_point values (118,3653,0.0091222,7);
insert into curve_point values (119,4383,0.0099394,7);
insert into curve_point values (120,5480,0.0106721,7);
insert into curve_point values (121,7307,0.0110843,7);
insert into curve_point values (122,9134,0.0110854,7);
insert into curve_point values (123,10957,0.0108872,7);
insert into curve_point values (124,14610,0.0102162,7);
insert into curve_point values (125,18262,0.0096351,7);
insert into curve_point values (126,21916,0.0093789,7);

insert into curve values (8,sysdate(),sysdate(),1,1,'GBP','2021-03-03',1,'GDP_6M',1);

insert into curve_point values (127,1,0.0010005,8);
insert into curve_point values (128,184,0.0009402,8);
insert into curve_point values (129,365,0.0009601,8);
insert into curve_point values (130,733,0.0024885,8);
insert into curve_point values (131,1097,0.0038611,8);
insert into curve_point values (132,1461,0.0051239,8);
insert into curve_point values (133,1826,0.0061895,8);
insert into curve_point values (134,2191,0.0071074,8);
insert into curve_point values (135,2557,0.0079435,8);
insert into curve_point values (136,3652,0.009932,8);
insert into curve_point values (137,4383,0.0107847,8);
insert into curve_point values (138,5479,0.0115542,8);
insert into curve_point values (139,7306,0.0119805,8);
insert into curve_point values (140,9133,0.01198,8);
insert into curve_point values (141,10960,0.0117706,8);
insert into curve_point values (142,14610,0.0110801,8);
insert into curve_point values (143,18262,0.0104886,8);
insert into curve_point values (144,21915,0.0103453,8);

insert into curve values (9,sysdate(),sysdate(),1,1,'GBP','2021-03-04',1,'GDP_6M',1);

insert into curve_point values (145,1,0.0009505,9);
insert into curve_point values (146,186,0.0009602,9);
insert into curve_point values (147,368,0.0010044,9);
insert into curve_point values (148,732,0.0025185,9);
insert into curve_point values (149,1096,0.0038965,9);
insert into curve_point values (150,1461,0.0051591,9);
insert into curve_point values (151,1826,0.0062401,9);
insert into curve_point values (152,2191,0.0071633,9);
insert into curve_point values (153,2559,0.0080046,9);
insert into curve_point values (154,3652,0.0099829,9);
insert into curve_point values (155,4386,0.0108372,9);
insert into curve_point values (156,5479,0.0116077,9);
insert into curve_point values (157,7305,0.0120642,9);
insert into curve_point values (158,9132,0.0120483,9);
insert into curve_point values (159,10959,0.0118185,9);
insert into curve_point values (160,14613,0.0111163,9);
insert into curve_point values (161,18262,0.0104846,9);
insert into curve_point values (162,21915,0.0096887,9);

insert into curve values (10,sysdate(),sysdate(),1,1,'GBP','2021-03-05',1,'GDP_6M',1);

insert into curve_point values (163,3,0.0010005,10);
insert into curve_point values (164,185,0.0009402,10);
insert into curve_point values (165,367,0.0009749,10);
insert into curve_point values (166,731,0.0025792,10);
insert into curve_point values (167,1096,0.0040031,10);
insert into curve_point values (168,1461,0.0053065,10);
insert into curve_point values (169,1826,0.0063618,10);
insert into curve_point values (170,2194,0.0072335,10);
insert into curve_point values (171,2558,0.0080229,10);
insert into curve_point values (172,3652,0.0098488,10);
insert into curve_point values (173,4385,0.010643,10);
insert into curve_point values (174,5479,0.011377,10);
insert into curve_point values (175,7305,0.0117658,10);
insert into curve_point values (176,9131,0.0116823,10);
insert into curve_point values (177,10958,0.0114106,10);
insert into curve_point values (178,14612,0.0106153,10);
insert into curve_point values (179,18262,0.0099159,10);
insert into curve_point values (180,21915,0.0096564,10);

insert into curve values (11,sysdate(),sysdate(),1,1,'EUR','2021-03-01',1,'EUR_6M',1);

insert into curve_point values (181,1,-0.00481,11);
insert into curve_point values (182,186,-0.0051747,11);
insert into curve_point values (183,367,-0.0050697,11);
insert into curve_point values (184,735,-0.0048641,11);
insert into curve_point values (185,1099,-0.0045282,11);
insert into curve_point values (186,1463,-0.0040346,11);
insert into curve_point values (187,1828,-0.0034469,11);
insert into curve_point values (188,2193,-0.0028089,11);
insert into curve_point values (189,2559,-0.0021498,11);
insert into curve_point values (190,2926,-0.0014891,11);
insert into curve_point values (191,3290,-0.0008464,11);
insert into curve_point values (192,3654,-0.0002316,11);
insert into curve_point values (193,4385,0.0008987,11);
insert into curve_point values (194,5481,0.002219,11);
insert into curve_point values (195,7308,0.0032903,11);
insert into curve_point values (196,9135,0.0034548,11);
insert into curve_point values (197,10962,0.0032584,11);
insert into curve_point values (198,14612,0.0027989,11);

insert into curve values (12,sysdate(),sysdate(),1,1,'EUR','2021-03-02',1,'EUR_6M',1);

insert into curve_point values (199,1,-0.00478,12);
insert into curve_point values (200,188,-0.005235,12);
insert into curve_point values (201,370,-0.0051067,12);
insert into curve_point values (202,734,-0.0049489,12);
insert into curve_point values (203,1098,-0.0046395,12);
insert into curve_point values (204,1463,-0.0041619,12);
insert into curve_point values (205,1828,-0.0035997,12);
insert into curve_point values (206,2193,-0.0029723,12);
insert into curve_point values (207,2561,-0.0023139,12);
insert into curve_point values (208,2925,-0.0016537,12);
insert into curve_point values (209,3289,-0.0010165,12);
insert into curve_point values (210,3654,-0.0003921,12);
insert into curve_point values (211,4388,0.0007679,12);
insert into curve_point values (212,5481,0.002108,12);
insert into curve_point values (213,7307,0.0032311,12);
insert into curve_point values (214,9134,0.0034377,12);
insert into curve_point values (215,10961,0.0032777,12);
insert into curve_point values (216,14615,0.0028218,12);

insert into curve values (13,sysdate(),sysdate(),1,1,'EUR','2021-03-03',1,'EUR_6M',1);

insert into curve_point values (217,1,-0.0048,13);
insert into curve_point values (218,187,-0.0052155,13);
insert into curve_point values (219,369,-0.0050904,13);
insert into curve_point values (220,733,-0.0048667,13);
insert into curve_point values (221,1098,-0.0044603,13);
insert into curve_point values (222,1463,-0.003904,13);
insert into curve_point values (223,1828,-0.0032376,13);
insert into curve_point values (224,2196,-0.0025401,13);
insert into curve_point values (225,2560,-0.0018209,13);
insert into curve_point values (226,2924,-0.0011245,13);
insert into curve_point values (227,3289,-0.0004357,13);
insert into curve_point values (228,3654,0.0002356,13);
insert into curve_point values (229,4387,0.0014347,13);
insert into curve_point values (230,5481,0.0028101,13);
insert into curve_point values (231,7307,0.0039832,13);
insert into curve_point values (232,9133,0.0042245,13);
insert into curve_point values (233,10960,0.0040913,13);
insert into curve_point values (234,14614,0.0036564,13);

insert into curve values (14,sysdate(),sysdate(),1,1,'EUR','2021-03-04',1,'EUR_6M',1);

insert into curve_point values (235,1,-0.0048,14);
insert into curve_point values (236,188,-0.0052462,14);
insert into curve_point values (237,369,-0.0050918,14);
insert into curve_point values (238,734,-0.0048877,14);
insert into curve_point values (239,1100,-0.0045248,14);
insert into curve_point values (240,1467,-0.0040031,14);
insert into curve_point values (241,1831,-0.0033814,14);
insert into curve_point values (242,2195,-0.0026992,14);
insert into curve_point values (243,2561,-0.0019903,14);
insert into curve_point values (244,2926,-0.0012894,14);
insert into curve_point values (245,3294,-0.0006061,14);
insert into curve_point values (246,3658,0.0000548,14);
insert into curve_point values (247,4387,0.0012479,14);
insert into curve_point values (248,5485,0.0026276,14);
insert into curve_point values (249,7312,0.0038111,14);
insert into curve_point values (250,9135,0.0040801,14);
insert into curve_point values (251,10961,0.0039478,14);
insert into curve_point values (252,14614,0.0035413,14);

insert into curve values (15,sysdate(),sysdate(),1,1,'EUR','2021-03-05',1,'EUR_6M',1);

insert into curve_point values (253,3,-0.0048,15);
insert into curve_point values (254,188,-0.0052288,15);
insert into curve_point values (255,369,-0.0050979,15);
insert into curve_point values (256,734,-0.0048636,15);
insert into curve_point values (257,1102,-0.0044591,15);
insert into curve_point values (258,1466,-0.0039113,15);
insert into curve_point values (259,1830,-0.0032641,15);
insert into curve_point values (260,2195,-0.0025662,15);
insert into curve_point values (261,2561,-0.0018417,15);
insert into curve_point values (262,2929,-0.0011301,15);
insert into curve_point values (263,3293,-0.000421,15);
insert into curve_point values (264,3657,0.0002456,15);
insert into curve_point values (265,4387,0.0014298,15);
insert into curve_point values (266,5484,0.0028109,15);
insert into curve_point values (267,7311,0.0039532,15);
insert into curve_point values (268,9138,0.0042008,15);
insert into curve_point values (269,10961,0.0040468,15);
insert into curve_point values (270,14614,0.0036455,15);
