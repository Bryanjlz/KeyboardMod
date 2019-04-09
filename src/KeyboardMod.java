
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.StandardOpenOption;
import java.awt.Robot;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

public class KeyboardMod implements HotkeyListener {
    private static final int CAPS_LOCK = 52;
    private static final int F1 = 53;
    private static final int F2 = 54;
    private static final int F3 = 55;
    private static final int F4 = 56;
    private static final int F5 = 57;
    private static boolean cancerCase;
    private static boolean randomCase;
    private static boolean normalCase = true;
    private static boolean accentCase;
    private static boolean caps;
    private static Robot matthew;

    KeyboardMod() throws AWTException {
        String userHome = System.getProperty("user.home");
        File file = new File(userHome, "my.lock");
        try {
            FileChannel fc = FileChannel.open(file.toPath(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
            FileLock lock = fc.tryLock();
            if (lock == null) {
                System.out.println("another instance is running");
            }
        } catch (IOException e) {
            throw new Error(e);
        }
        JIntellitype.getInstance().addHotKeyListener(this);
        matthew = new Robot();
        for (int i = 0; i < 26; i++) {
            JIntellitype.getInstance().registerHotKey(i, 0, 65 + i);
        }
        for (int i = 0; i < 26; i++) {
            JIntellitype.getInstance().registerHotKey(26 + i, JIntellitype.MOD_SHIFT, 65 + i);
        }

        JIntellitype.getInstance().registerHotKey(F1, 0, 112);
        JIntellitype.getInstance().registerHotKey(F2, 0, 113);
        JIntellitype.getInstance().registerHotKey(F3, 0, 114);
        JIntellitype.getInstance().registerHotKey(F4, 0, 115);
        JIntellitype.getInstance().registerHotKey(F5, 0, 116);
        JIntellitype.getInstance().registerHotKey(CAPS_LOCK, 0, 20);
    }

    @Override
    public void onHotKey(int aIdentifier) {
        switch (aIdentifier) {
            case 0:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_2);
                    matthew.keyRelease(KeyEvent.VK_2);
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                } else if (accentCase && !caps) {
                    int random = (int) (Math.random() * 6);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(224 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    int random = (int) (Math.random() * 6);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(192 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("65");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("97");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 1:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("225");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("66");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("98");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 2:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0162");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && !caps) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("135");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("128");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("67");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("99");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 3:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0208");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("68");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("100");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 4:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("238");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && !caps) {
                    int random = (int) (Math.random() * 4);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(232 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    int random = (int) (Math.random() * 4);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(200 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("69");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("101");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 5:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("159");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("70");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("102");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 6:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_9);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("71");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("103");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 7:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0181");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("72");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("104");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 8:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0135");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && !caps) {
                    int random = (int) (Math.random() * 4);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(236 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    int random = (int) (Math.random() * 4);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(204 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("73");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("105");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 9:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("245");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("74");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("106");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 10:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_BACK_SLASH);
                    matthew.keyRelease(KeyEvent.VK_BACK_SLASH);
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0139");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("75");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("107");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 11:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("200");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("76");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("108");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 12:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_6);
                    matthew.keyRelease(KeyEvent.VK_6);
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_6);
                    matthew.keyRelease(KeyEvent.VK_6);
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("77");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("109");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 13:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("239");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && !caps) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("164");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0209");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("78");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("110");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 14:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("10");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && !caps) {
                    int random = (int) (Math.random() * 5);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(242 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    int random = (int) (Math.random() * 5);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(210 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("79");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("111");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 15:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0254");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("80");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("112");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 16:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("11");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("81");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("113");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 17:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("218");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("82");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("114");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 18:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("21");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && !caps) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0154");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0138");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("83");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("115");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 19:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("231");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("84");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("116");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 20:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("129");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && !caps) {
                    int random = (int) (Math.random() * 4);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(249 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    int random = (int) (Math.random() * 4);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(217 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("85");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("117");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 21:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("251");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("86");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("118");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 22:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("118");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("118");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("87");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("119");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 23:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0215");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("88");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("120");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 24:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0165");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && !caps) {
                    int random = (int) (Math.random() * 2);
                    String code = "";
                    if (random == 0) {
                        code = "0253";
                    } else {
                        code = "0255";
                    }
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode(code);
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    int random = (int) (Math.random() * 2);
                    String code = "";
                    if (random == 0) {
                        code = "0159";
                    } else {
                        code = "0221";
                    }
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode(code);
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("89");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("121");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 25:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0142");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && !caps) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0158");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0142");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && caps)) {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("90");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    } else {
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("122");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                    }
                }
                break;
            case 26:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_2);
                    matthew.keyRelease(KeyEvent.VK_2);
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                } else if (accentCase && caps) {
                    int random = (int) (Math.random() * 6);
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(224 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else if (accentCase && !caps) {
                    int random = (int) (Math.random() * 6);
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(192 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("65");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);

                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("97");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 27:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("225");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("66");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("98");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 28:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0162");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("135");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else if (accentCase && !caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("128");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("67");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("99");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 29:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0208");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("68");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("100");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 30:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("238");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    int random = (int) (Math.random() * 4);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(232 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else if (accentCase && !caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    int random = (int) (Math.random() * 4);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(200 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("69");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("101");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 31:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("159");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("70");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("102");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 32:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_9);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("71");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("103");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 33:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0181");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("72");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("104");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 34:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0135");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    int random = (int) (Math.random() * 4);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(236 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else if (accentCase && !caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    int random = (int) (Math.random() * 4);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(204 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("73");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("105");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 35:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("245");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("74");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("106");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 36:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_BACK_SLASH);
                    matthew.keyRelease(KeyEvent.VK_BACK_SLASH);
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0139");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("75");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("107");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 37:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("200");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("76");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("108");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 38:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_6);
                    matthew.keyRelease(KeyEvent.VK_6);
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_6);
                    matthew.keyRelease(KeyEvent.VK_6);
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("77");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("109");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 39:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("239");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("164");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else if (accentCase && !caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0209");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("78");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("110");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 40:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("10");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    int random = (int) (Math.random() * 5);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(242 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else if (accentCase && !caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    int random = (int) (Math.random() * 5);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(210 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("79");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("111");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 41:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0254");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("80");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("112");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 42:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("11");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("81");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("113");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 43:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("218");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("82");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("114");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 44:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("21");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0154");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else if (accentCase && !caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0138");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("83");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("115");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 45:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("231");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("84");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("116");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 46:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("129");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    int random = (int) (Math.random() * 4);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(249 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else if (accentCase && !caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    int random = (int) (Math.random() * 4);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0" + Integer.toString(217 + random));
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("85");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("117");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 47:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("251");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("86");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("118");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 48:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("118");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("118");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("87");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("119");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 49:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0215");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || ((accentCase || normalCase) && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("88");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("120");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 50:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0165");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    int random = (int) (Math.random() * 2);
                    String code = "";
                    if (random == 0) {
                        code = "0253";
                    } else {
                        code = "0255";
                    }
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode(code);
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else if (accentCase && !caps) {
                    int random = (int) (Math.random() * 2);
                    String code = "";
                    if (random == 0) {
                        code = "0159";
                    } else {
                        code = "0221";
                    }
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode(code);
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("89");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("121");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case 51:
                if (cancerCase) {
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0142");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                } else if (accentCase && caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0158");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else if (accentCase && !caps) {
                    matthew.keyRelease(KeyEvent.VK_SHIFT);
                    matthew.keyPress(KeyEvent.VK_ALT);
                    enterCode("0142");
                    matthew.keyRelease(KeyEvent.VK_ALT);
                    matthew.keyPress(KeyEvent.VK_SHIFT);
                } else {
                    int random = (int) (Math.random() * 2);
                    if ((random == 1 && randomCase) || (normalCase && !caps)) {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("90");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    } else {
                        matthew.keyRelease(KeyEvent.VK_SHIFT);
                        matthew.keyPress(KeyEvent.VK_ALT);
                        enterCode("122");
                        matthew.keyRelease(KeyEvent.VK_ALT);
                        matthew.keyPress(KeyEvent.VK_SHIFT);
                    }
                }
                break;
            case CAPS_LOCK:
                if (caps) {
                    caps = false;
                } else {
                    caps = true;
                }
                break;
            case F1:
                System.exit(0);
                break;
            case F2:
                normalCase = true;
                cancerCase = false;
                randomCase = false;
                accentCase = false;
                break;
            case F3:
                randomCase = true;
                normalCase = false;
                cancerCase = false;
                accentCase = false;
                break;
            case F4:
                accentCase = true;
                normalCase = false;
                cancerCase = false;
                randomCase = false;
                break;
            case F5:
                cancerCase = true;
                normalCase = false;
                randomCase = false;
                accentCase = false;
                break;

        }

    }

    public void enterCode(String code) {
        if (code.length() > 0) {
            int num = Integer.parseInt(code.substring(0, 1));
            if (num == 0) {
                zero();
            } else if (num == 1) {
                one();
            } else if (num == 2) {
                two();
            } else if (num == 3) {
                three();
            } else if (num == 4) {
                four();
            } else if (num == 5) {
                five();
            } else if (num == 6) {
                six();
            } else if (num == 7) {
                seven();
            } else if (num == 8) {
                eight();
            } else if (num == 9) {
                nine();
            }
            enterCode(code.substring(1));
        }
    }

    public void zero() {
        matthew.keyPress(KeyEvent.VK_NUMPAD0);
        matthew.keyRelease(KeyEvent.VK_NUMPAD0);
    }

    public void one() {
        matthew.keyPress(KeyEvent.VK_NUMPAD1);
        matthew.keyRelease(KeyEvent.VK_NUMPAD1);
    }

    public void two() {
        matthew.keyPress(KeyEvent.VK_NUMPAD2);
        matthew.keyRelease(KeyEvent.VK_NUMPAD2);
    }

    public void three() {
        matthew.keyPress(KeyEvent.VK_NUMPAD3);
        matthew.keyRelease(KeyEvent.VK_NUMPAD3);
    }

    public void four() {
        matthew.keyPress(KeyEvent.VK_NUMPAD4);
        matthew.keyRelease(KeyEvent.VK_NUMPAD4);
    }

    public void five() {
        matthew.keyPress(KeyEvent.VK_NUMPAD5);
        matthew.keyRelease(KeyEvent.VK_NUMPAD5);
    }

    public void six() {
        matthew.keyPress(KeyEvent.VK_NUMPAD6);
        matthew.keyRelease(KeyEvent.VK_NUMPAD6);
    }

    public void seven() {
        matthew.keyPress(KeyEvent.VK_NUMPAD7);
        matthew.keyRelease(KeyEvent.VK_NUMPAD7);
    }

    public void eight() {
        matthew.keyPress(KeyEvent.VK_NUMPAD8);
        matthew.keyRelease(KeyEvent.VK_NUMPAD8);
    }

    public void nine() {
        matthew.keyPress(KeyEvent.VK_NUMPAD9);
        matthew.keyRelease(KeyEvent.VK_NUMPAD9);
    }

}